public void resize ( final long length ) {
    final int need = ( int ) growthNeeded ( length );
    if ( bits.length != need ) {
        bits = Arrays.copyOf ( bits, need );
    }
    final int shift = ( int ) ( length & BITMASK );
    int slot = ( int ) ( length >> BITSHIFT );
    if ( shift != 0 ) {
        bits[slot] &= ( 1L << shift ) - 1;
        slot++;
    }
    for ( ; slot < bits.length; slot++ ) {
        bits[slot] = 0;
    }
}
