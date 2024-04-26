public OrderedBidiMap<V, K> inverseOrderedBidiMap() {
    if ( inverse == null ) {
        inverse = new UnmodifiableOrderedBidiMap<> ( decorated().inverseBidiMap() );
        inverse.inverse = this;
    }
    return inverse;
}
