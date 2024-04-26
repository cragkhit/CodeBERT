public static int getVIntSize ( long i ) {
    if ( i >= -112 && i <= 127 ) {
        return 1;
    }
    if ( i < 0 ) {
        i ^= -1L; 
    }
    int dataBits = Long.SIZE - Long.numberOfLeadingZeros ( i );
    return ( dataBits + 7 ) / 8 + 1;
}
