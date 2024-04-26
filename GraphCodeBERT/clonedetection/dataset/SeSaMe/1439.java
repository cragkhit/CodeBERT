@Override
public E next() {
    if ( !nextObjectSet && !setNextObject() ) {
        throw new NoSuchElementException();
    }
    nextObjectSet = false;
    return nextObject;
}
