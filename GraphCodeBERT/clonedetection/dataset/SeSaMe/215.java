@Override
public void putAll ( Map<? extends K, ? extends V> m ) {
    for ( Map.Entry<? extends K, ? extends V> e : m.entrySet() ) {
        put ( e.getKey(), e.getValue() );
    }
}
