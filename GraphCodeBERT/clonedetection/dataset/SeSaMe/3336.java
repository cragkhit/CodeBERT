public int key()
throws ConcurrentModificationException, NoSuchElementException {
    if ( referenceCount != count ) {
        throw new ConcurrentModificationException();
    }
    if ( current < 0 ) {
        throw new NoSuchElementException();
    }
    return keys[current];
}
