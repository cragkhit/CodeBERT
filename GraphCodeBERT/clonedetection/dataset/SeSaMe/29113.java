public boolean containsValue ( Object value ) {
    if ( value == null ) {
        throw new NullPointerException();
    }
    Node<K, V>[] t;
    if ( ( t = table ) != null ) {
        Traverser<K, V> it = new Traverser<K, V> ( t, t.length, 0, t.length );
        for ( Node<K, V> p; ( p = it.advance() ) != null; ) {
            V v;
            if ( ( v = p.val ) == value || ( v != null && value.equals ( v ) ) ) {
                return true;
            }
        }
    }
    return false;
}
