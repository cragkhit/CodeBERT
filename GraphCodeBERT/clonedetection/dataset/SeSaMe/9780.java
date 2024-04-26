public synchronized boolean removeKey ( T1 key ) {
    Set<T2> values = _forward.get ( key );
    if ( null == values ) {
        assert checkIntegrity();
        return false;
    }
    for ( T2 value : values ) {
        Set<T1> keys = _reverse.get ( value );
        if ( null != keys ) {
            keys.remove ( key );
            if ( keys.isEmpty() ) {
                _reverse.remove ( value );
            }
        }
    }
    _forward.remove ( key );
    _dirty = true;
    assert checkIntegrity();
    return true;
}
