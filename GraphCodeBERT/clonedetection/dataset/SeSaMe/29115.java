public void putAll ( Map<? extends K, ? extends V> m ) {
    tryPresize ( m.size() );
    for ( Map.Entry<? extends K, ? extends V> e : m.entrySet() ) {
        putVal ( e.getKey(), e.getValue(), false );
    }
}
