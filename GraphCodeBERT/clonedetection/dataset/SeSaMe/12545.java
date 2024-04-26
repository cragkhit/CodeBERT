public void reportFreeBlocks() throws IndexException {
    System.out.println ( "Allocated size: " + formatByteString ( getDatabaseSize() ) ); 
    System.out.println ( "malloc'ed: " + formatByteString ( this.malloced ) ); 
    System.out.println ( "free'd: " + formatByteString ( this.freed ) ); 
    System.out.println ( "wasted: " + formatByteString ( ( getDatabaseSize() - ( this.malloced - this.freed ) ) ) ); 
    System.out.println ( "Free blocks" ); 
    for ( int bs = MIN_BLOCK_DELTAS * BLOCK_SIZE_DELTA; bs <= CHUNK_SIZE; bs += BLOCK_SIZE_DELTA ) {
        int count = 0;
        long block = getFirstBlock ( bs );
        while ( block != 0 ) {
            ++count;
            block = getFreeRecPtr ( block + BLOCK_NEXT_OFFSET );
        }
        if ( count != 0 ) {
            System.out.println ( "Block size: " + bs + "=" + count );    
        }
    }
}
