public CacheBuilder<K, V> ticker ( Ticker ticker ) {
    checkState ( this.ticker == null );
    this.ticker = checkNotNull ( ticker );
    return this;
}
