Entry<K, V> getEntry ( Object key ) {
    Object k = maskNull ( key );
    int h = hash ( k );
    Entry<K, V>[] tab = getTable();
    int index = indexFor ( h, tab.length );
    Entry<K, V> e = tab[index];
    while ( e != null && ! ( e.hash == h && eq ( k, e.get() ) ) ) {
        e = e.next;
    }
    return e;
}
