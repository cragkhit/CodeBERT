public E getFirst() {
    if ( size == 0 ) {
        throw new NoSuchElementException();
    }
    return header.next.element;
}
