@Override
public V get ( Object key ) {
    Segment<K, V> s; 
    HashEntry<K, V>[] tab;
    int h = hash ( key );
    long u = ( ( ( h >>> segmentShift ) & segmentMask ) << SSHIFT ) + SBASE;
    if ( ( s = ( Segment<K, V> ) UNSAFE.getObjectVolatile ( segments, u ) ) != null &&
            ( tab = s.table ) != null ) {
        for ( HashEntry<K, V> e = ( HashEntry<K, V> ) UNSAFE.getObjectVolatile
                                  ( tab, ( ( long ) ( ( ( tab.length - 1 ) & h ) ) << TSHIFT ) + TBASE );
                e != null; e = e.next ) {
            K k;
            if ( ( k = e.key ) == key || ( e.hash == h && key.equals ( k ) ) ) {
                return e.value;
            }
        }
    }
    return null;
}
