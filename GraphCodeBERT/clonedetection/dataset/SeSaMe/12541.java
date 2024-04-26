public void memcpy ( long dest, long source, int numBytes ) {
    assert numBytes >= 0;
    long endAddress = source + numBytes;
    assert endAddress <= ( long ) this.fChunksUsed * CHUNK_SIZE;
    for ( int count = 0; count < numBytes; count++ ) {
        putByte ( dest + count, getByte ( source + count ) );
    }
}
