public long parseLong() throws IOException {
    skipWhitespace();
    byte b = readByte();
    if ( !Character.isDigit ( ( char ) b ) ) {
        error();
    }
    long l = 0;
    while ( Character.isDigit ( ( char ) b ) ) {
        l *= 10;
        l += ( b - '0' );
        b = readByte();
    }
    pushBack ( b );
    return l;
}
