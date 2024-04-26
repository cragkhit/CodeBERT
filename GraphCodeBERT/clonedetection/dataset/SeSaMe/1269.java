@Override
public V get ( final Object key ) {
    removeIfExpired ( key, now() );
    return super.get ( key );
}
