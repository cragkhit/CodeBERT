public void advance()
throws ConcurrentModificationException, NoSuchElementException {
    if ( referenceCount != count ) {
        throw new ConcurrentModificationException();
    }
    current = next;
    try {
        while ( states[++next] != FULL ) { 
        }
    } catch ( ArrayIndexOutOfBoundsException e ) {
        next = -2;
        if ( current < 0 ) {
            throw new NoSuchElementException();
        }
    }
}
