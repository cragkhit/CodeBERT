public static int mean ( int x, int y ) {
    return ( x & y ) + ( ( x ^ y ) >> 1 );
}
