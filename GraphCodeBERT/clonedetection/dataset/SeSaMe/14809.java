public void removeRange ( int fromIndex, int toIndex ) {
    if ( fromIndex > toIndex ) {
        throw new IllegalArgumentException ( "fromIndex must be <= toIndex" );
    }
    for ( int i = toIndex; i >= fromIndex; i-- ) {
        delegate.removeElementAt ( i );
    }
    fireIntervalRemoved ( this, fromIndex, toIndex );
}
