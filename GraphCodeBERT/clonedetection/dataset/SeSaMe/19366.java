@GwtIncompatible 
public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> weigher (
    Weigher<? super K1, ? super V1> weigher ) {
    checkState ( this.weigher == null );
    if ( strictParsing ) {
        checkState (
            this.maximumSize == UNSET_INT,
            "weigher can not be combined with maximum size",
            this.maximumSize );
    }
    @SuppressWarnings ( "unchecked" )
    CacheBuilder<K1, V1> me = ( CacheBuilder<K1, V1> ) this;
    me.weigher = checkNotNull ( weigher );
    return me;
}
