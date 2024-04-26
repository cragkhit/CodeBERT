protected void checkLocked() {
    if ( isLocked() ) {
        throw new UnsupportedOperationException ( "Cannot modify a FixedOrderComparator after a comparison" );
    }
}
