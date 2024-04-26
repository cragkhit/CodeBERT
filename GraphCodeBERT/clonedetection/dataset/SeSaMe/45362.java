public void addElement ( E element ) {
    int index = delegate.size();
    delegate.addElement ( element );
    fireIntervalAdded ( this, index, index );
}
