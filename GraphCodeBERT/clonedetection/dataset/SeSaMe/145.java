@NonNull
public Caffeine<K, V> ticker ( @NonNull Ticker ticker ) {
    requireState ( this.ticker == null, "Ticker was already set to %s", this.ticker );
    this.ticker = requireNonNull ( ticker );
    return this;
}
