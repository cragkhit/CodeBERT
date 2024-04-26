@Override
public E previous() {
    if ( hasPrevious() == false ) {
        throw new NoSuchElementException();
    }
    this.lastItemIndex = --this.index;
    return this.array[this.index];
}
