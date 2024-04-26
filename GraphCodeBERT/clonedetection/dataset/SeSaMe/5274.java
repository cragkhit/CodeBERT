public static void skipFully ( DataInput in, int len ) throws IOException {
    int total = 0;
    int cur = 0;
    while ( ( total < len ) && ( ( cur = in.skipBytes ( len - total ) ) > 0 ) ) {
        total += cur;
    }
    if ( total < len ) {
        throw new IOException ( "Not able to skip " + len + " bytes, possibly " + "due to end of input." );
    }
}
