public final SecretKey generateKey() {
    if ( serviceIterator == null ) {
        return spi.engineGenerateKey();
    }
    RuntimeException failure = null;
    KeyGeneratorSpi mySpi = spi;
    do {
        try {
            return mySpi.engineGenerateKey();
        } catch ( RuntimeException e ) {
            if ( failure == null ) {
                failure = e;
            }
            mySpi = nextSpi ( mySpi, true );
        }
    } while ( mySpi != null );
    throw failure;
}
