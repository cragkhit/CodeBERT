@NonNull
public <K1 extends K, V1 extends V> Caffeine<K1, V1> removalListener (
    @NonNull RemovalListener<? super K1, ? super V1> removalListener ) {
    requireState ( this.removalListener == null,
                   "removal listener was already set to %s", this.removalListener );
    @SuppressWarnings ( "unchecked" )
    Caffeine<K1, V1> self = ( Caffeine<K1, V1> ) this;
    self.removalListener = requireNonNull ( removalListener );
    return self;
}
