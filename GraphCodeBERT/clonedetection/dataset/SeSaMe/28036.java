public void nextBytes ( byte[] bytes ) {
    int i = 0;
    int len = bytes.length;
    for ( int words = len >> 3; words--> 0; ) {
        long rnd = nextLong();
        for ( int n = 8; n--> 0; rnd >>>= Byte.SIZE ) {
            bytes[i++] = ( byte ) rnd;
        }
    }
    if ( i < len )
        for ( long rnd = nextLong(); i < len; rnd >>>= Byte.SIZE ) {
            bytes[i++] = ( byte ) rnd;
        }
}
