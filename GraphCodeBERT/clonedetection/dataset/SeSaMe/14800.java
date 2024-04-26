public void insertElementAt ( E element, int index ) {
    delegate.insertElementAt ( element, index );
    fireIntervalAdded ( this, index, index );
}
