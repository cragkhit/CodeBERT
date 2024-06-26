public V get ( Object key ) {
    Node<K, V>[] tab;
    Node<K, V> e, p;
    int n, eh;
    K ek;
    int h = spread ( key.hashCode() );
    if ( ( tab = table ) != null && ( n = tab.length ) > 0 &&
            ( e = tabAt ( tab, ( n - 1 ) & h ) ) != null ) {
        if ( ( eh = e.hash ) == h ) {
            if ( ( ek = e.key ) == key || ( ek != null && key.equals ( ek ) ) ) {
                return e.val;
            }
        } else if ( eh < 0 ) {
            return ( p = e.find ( h, key ) ) != null ? p.val : null;
        }
        while ( ( e = e.next ) != null ) {
            if ( e.hash == h &&
                    ( ( ek = e.key ) == key || ( ek != null && key.equals ( ek ) ) ) ) {
                return e.val;
            }
        }
    }
    return null;
}
