public boolean removeElement ( Object obj ) {
    int index = indexOf ( obj );
    boolean rv = delegate.removeElement ( obj );
    if ( index >= 0 ) {
        fireIntervalRemoved ( this, index, index );
    }
    return rv;
}
