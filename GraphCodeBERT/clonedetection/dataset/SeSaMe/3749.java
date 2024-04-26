public Neuron getNeuron ( long id ) {
    final Neuron n = neuronMap.get ( id );
    if ( n == null ) {
        throw new NoSuchElementException ( Long.toString ( id ) );
    }
    return n;
}
