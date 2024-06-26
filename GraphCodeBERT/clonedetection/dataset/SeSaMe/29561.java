public void putAll ( Map<? extends K, ? extends V> m ) {
    int numKeysToBeAdded = m.size();
    if ( numKeysToBeAdded == 0 ) {
        return;
    }
    if ( numKeysToBeAdded > threshold ) {
        int targetCapacity = ( int ) ( numKeysToBeAdded / loadFactor + 1 );
        if ( targetCapacity > MAXIMUM_CAPACITY ) {
            targetCapacity = MAXIMUM_CAPACITY;
        }
        int newCapacity = table.length;
        while ( newCapacity < targetCapacity ) {
            newCapacity <<= 1;
        }
        if ( newCapacity > table.length ) {
            resize ( newCapacity );
        }
    }
    for ( Map.Entry<? extends K, ? extends V> e : m.entrySet() ) {
        put ( e.getKey(), e.getValue() );
    }
}
