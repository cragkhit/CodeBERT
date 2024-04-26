public char[] getContents() {
    if ( this.end == 0 ) {
        return null;
    }
    int length = 0;
    for ( int i = 0; i < this.end; i++ ) {
        length += this.ranges[i][1];
    }
    if ( length > 0 ) {
        char[] result = new char[length];
        int current = 0;
        for ( int i = 0; i < this.end; i++ ) {
            int[] range = this.ranges[i];
            int length2 = range[1];
            System.arraycopy ( this.buffer[i], range[0], result, current, length2 );
            current += length2;
        }
        return result;
    }
    return null;
}
