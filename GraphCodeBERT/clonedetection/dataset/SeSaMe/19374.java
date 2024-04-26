@CheckReturnValue
public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> removalListener (
    RemovalListener<? super K1, ? super V1> listener ) {
    checkState ( this.removalListener == null );
    @SuppressWarnings ( "unchecked" )
    CacheBuilder<K1, V1> me = ( CacheBuilder<K1, V1> ) this;
    me.removalListener = checkNotNull ( listener );
    return me;
}
