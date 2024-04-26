@SuppressWarnings ( {"unchecked"} )
protected void rehash ( int newCapacity ) {
    int oldCapacity = _set.length;
    int oldSize = size();
    Object oldKeys[] = _set;
    V oldVals[] = _values;
    _set = new Object[newCapacity];
    Arrays.fill ( _set, FREE );
    _values = ( V[] ) new Object[newCapacity];
    int count = 0;
    for ( int i = oldCapacity; i-- > 0; ) {
        Object o = oldKeys[i];
        if ( o == FREE || o == REMOVED ) {
            continue;
        }
        int index = insertKey ( ( K ) o );
        if ( index < 0 ) {
            throwObjectContractViolation ( _set[ ( -index - 1 )], o, size(), oldSize, oldKeys );
        }
        _values[index] = oldVals[i];
        count++;
    }
    reportPotentialConcurrentMod ( size(), oldSize );
}
