protected void rnnUpdateStateWithTBPTTState() {
    for ( int i = 0; i < layers.length; i++ ) {
        if ( layers[i] instanceof RecurrentLayer ) {
            RecurrentLayer l = ( ( RecurrentLayer ) layers[i] );
            l.rnnSetPreviousState ( l.rnnGetTBPTTState() );
        } else if ( layers[i] instanceof MultiLayerNetwork ) {
            ( ( MultiLayerNetwork ) layers[i] ).updateRnnStateWithTBPTTState();
        }
    }
}
