public double getProbability ( T element ) {
    if ( totalCount() <= 0.0 ) {
        throw new IllegalStateException ( "Can't calculate probability with empty counter" );
    }
    return getCount ( element ) / totalCount();
}
