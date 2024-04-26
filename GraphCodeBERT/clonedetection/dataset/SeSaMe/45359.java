public void setElementAt ( E element, int index ) {
    delegate.setElementAt ( element, index );
    fireContentsChanged ( this, index, index );
}
