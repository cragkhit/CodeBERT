public void initGradientsView() {
    try ( MemoryWorkspace ws = Nd4j.getMemoryManager().scopeOutOfWorkspaces() ) {
        if ( layers == null ) {
            init();
        }
        int nLayers = layers.length;
        int paramLength = 0;
        val nParamsPerLayer = new long[nLayers];
        for ( int i = 0; i < nLayers; i++ ) {
            NeuralNetConfiguration conf = layerWiseConfigurations.getConf ( i );
            nParamsPerLayer[i] = conf.getLayer().initializer().numParams ( conf );
            paramLength += nParamsPerLayer[i];
        }
        if ( paramLength > 0 ) {
            flattenedGradients = Nd4j.zeros ( new int[] {1, paramLength}, 'f' ); 
        }
        int backpropParamsSoFar = 0;
        for ( int i = 0; i < layers.length; i++ ) {
            if ( nParamsPerLayer[i] == 0 ) {
                continue;    
            }
            INDArray thisLayerGradView = flattenedGradients.get ( NDArrayIndex.point ( 0 ),
                                         NDArrayIndex.interval ( backpropParamsSoFar, backpropParamsSoFar + nParamsPerLayer[i] ) );
            layers[i].setBackpropGradientsViewArray ( thisLayerGradView );
            backpropParamsSoFar += nParamsPerLayer[i];
        }
    }
}
