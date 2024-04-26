protected Iterator<K> createKeySetIterator() {
    if ( size() == 0 ) {
        return EmptyIterator.<K>emptyIterator();
    }
    return new KeySetIterator<> ( this );
}
