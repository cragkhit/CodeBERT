@Override
protected AlgorithmParameters engineGenerateParameters() {
    if ( random == null ) {
        random = SunJCE.getRandom();
    }
    BigInteger paramP = null;
    BigInteger paramG = null;
    try {
        AlgorithmParameterGenerator dsaParamGen =
            AlgorithmParameterGenerator.getInstance ( "DSA" );
        dsaParamGen.init ( primeSize, random );
        AlgorithmParameters dsaParams = dsaParamGen.generateParameters();
        DSAParameterSpec dsaParamSpec =
            dsaParams.getParameterSpec ( DSAParameterSpec.class );
        DHParameterSpec dhParamSpec;
        if ( this.exponentSize > 0 ) {
            dhParamSpec = new DHParameterSpec ( dsaParamSpec.getP(),
                                                dsaParamSpec.getG(),
                                                this.exponentSize );
        } else {
            dhParamSpec = new DHParameterSpec ( dsaParamSpec.getP(),
                                                dsaParamSpec.getG() );
        }
        AlgorithmParameters algParams =
            AlgorithmParameters.getInstance ( "DH", SunJCE.getInstance() );
        algParams.init ( dhParamSpec );
        return algParams;
    } catch ( Exception ex ) {
        throw new ProviderException ( "Unexpected exception", ex );
    }
}
