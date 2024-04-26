final int bitIndex ( final K key, final K foundKey ) {
    return keyAnalyzer.bitIndex ( key, 0, lengthInBits ( key ), foundKey, 0, lengthInBits ( foundKey ) );
}
