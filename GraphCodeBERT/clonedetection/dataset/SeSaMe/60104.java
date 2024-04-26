public void putAll ( Map<? extends K, ? extends V> map ) {
    ensureCapacity ( map.size() );
    for ( Map.Entry<? extends K, ? extends V> e : map.entrySet() ) {
        put ( e.getKey(), e.getValue() );
    }
}
