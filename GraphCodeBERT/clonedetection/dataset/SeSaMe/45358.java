public void setSize ( int newSize ) {
    int oldSize = delegate.size();
    delegate.setSize ( newSize );
    if ( oldSize > newSize ) {
        fireIntervalRemoved ( this, newSize, oldSize - 1 );
    } else if ( oldSize < newSize ) {
        fireIntervalAdded ( this, oldSize, newSize - 1 );
    }
}
