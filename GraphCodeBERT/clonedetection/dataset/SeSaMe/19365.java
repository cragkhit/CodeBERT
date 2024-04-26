@GwtIncompatible 
public CacheBuilder<K, V> maximumWeight ( long maximumWeight ) {
    checkState (
        this.maximumWeight == UNSET_INT,
        "maximum weight was already set to %s",
        this.maximumWeight );
    checkState (
        this.maximumSize == UNSET_INT, "maximum size was already set to %s", this.maximumSize );
    this.maximumWeight = maximumWeight;
    checkArgument ( maximumWeight >= 0, "maximum weight must not be negative" );
    return this;
}
