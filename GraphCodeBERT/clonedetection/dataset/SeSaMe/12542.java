public long malloc ( final long datasize, final short poolId ) throws IndexException {
    assert this.fExclusiveLock;
    assert datasize >= 0;
    assert datasize <= MAX_MALLOC_SIZE;
    long result;
    int usedSize;
    this.log.start ( this.mallocTag );
    try {
        if ( datasize >= MAX_SINGLE_BLOCK_MALLOC_SIZE ) {
            int newChunkNum = createLargeBlock ( datasize );
            usedSize = Math.abs ( getBlockHeaderForChunkNum ( newChunkNum ) ) * CHUNK_SIZE;
            result = ( long ) newChunkNum * CHUNK_SIZE + LargeBlock.HEADER_SIZE;
            clearRange ( result, usedSize - LargeBlock.HEADER_SIZE - LargeBlock.FOOTER_SIZE );
            result = result + BLOCK_HEADER_SIZE;
        } else {
            long freeBlock = 0;
            int needDeltas = divideRoundingUp ( datasize + BLOCK_HEADER_SIZE, BLOCK_SIZE_DELTA );
            if ( needDeltas < MIN_BLOCK_DELTAS ) {
                needDeltas = MIN_BLOCK_DELTAS;
            }
            int useDeltas;
            for ( useDeltas = needDeltas; useDeltas <= MAX_BLOCK_DELTAS; useDeltas++ ) {
                freeBlock = getFirstBlock ( useDeltas * BLOCK_SIZE_DELTA );
                if ( freeBlock != 0 ) {
                    break;
                }
            }
            Chunk chunk;
            if ( freeBlock == 0 ) {
                freeBlock = ( long ) ( createLargeBlock ( datasize ) ) * ( long ) CHUNK_SIZE + LargeBlock.HEADER_SIZE;
                useDeltas = MAX_BLOCK_DELTAS;
                chunk = getChunk ( freeBlock );
            } else {
                chunk = getChunk ( freeBlock );
                chunk.makeDirty();
                int blockReportedSize = chunk.getShort ( freeBlock );
                if ( blockReportedSize != useDeltas * BLOCK_SIZE_DELTA ) {
                    throw describeProblem()
                    .addProblemAddress ( "block size", freeBlock, SHORT_SIZE ) 
                    .build (
                        "Heap corruption detected in free space list. Block " + freeBlock 
                        + " reports a size of " + blockReportedSize + " but was in the list for blocks of size "  
                        + useDeltas * BLOCK_SIZE_DELTA );
                }
                removeBlock ( chunk, useDeltas * BLOCK_SIZE_DELTA, freeBlock );
            }
            final int unusedDeltas = useDeltas - needDeltas;
            if ( unusedDeltas >= MIN_BLOCK_DELTAS ) {
                addBlock ( chunk, unusedDeltas * BLOCK_SIZE_DELTA, freeBlock + needDeltas * BLOCK_SIZE_DELTA );
                useDeltas = needDeltas;
            }
            usedSize = useDeltas * BLOCK_SIZE_DELTA;
            chunk.putShort ( freeBlock, ( short ) - usedSize );
            chunk.clear ( freeBlock + BLOCK_HEADER_SIZE, usedSize - BLOCK_HEADER_SIZE );
            result = freeBlock + BLOCK_HEADER_SIZE;
        }
    } finally {
        this.log.end ( this.mallocTag );
    }
    this.log.recordMalloc ( result, usedSize - BLOCK_HEADER_SIZE );
    this.malloced += usedSize;
    this.memoryUsage.recordMalloc ( poolId, usedSize );
    if ( DEBUG_FREE_SPACE ) {
        boolean performedValidation = periodicValidateFreeSpace();
        if ( performedValidation ) {
            verifyNotInFreeSpaceList ( result );
        }
    }
    return result;
}
