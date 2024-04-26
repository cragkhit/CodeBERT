@NonNull
public <K1 extends K, V1 extends V> Caffeine<K1, V1> weigher (
    @NonNull Weigher<? super K1, ? super V1> weigher ) {
    requireNonNull ( weigher );
    requireState ( this.weigher == null, "weigher was already set to %s", this.weigher );
    requireState ( !strictParsing || this.maximumSize == UNSET_INT,
                   "weigher can not be combined with maximum size", this.maximumSize );
    @SuppressWarnings ( "unchecked" )
    Caffeine<K1, V1> self = ( Caffeine<K1, V1> ) this;
    self.weigher = weigher;
    return self;
}
