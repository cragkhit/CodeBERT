@Override
public void putAll ( final Map<? extends K, ? extends V> map ) {
    final int size = map.size();
    if ( size == 0 ) {
        return;
    }
    if ( delegateMap != null ) {
        delegateMap.putAll ( map );
        return;
    }
    if ( size < 4 ) {
        for ( final Map.Entry<? extends K, ? extends V> entry : map.entrySet() ) {
            put ( entry.getKey(), entry.getValue() );
        }
    } else {
        convertToMap();
        delegateMap.putAll ( map );
    }
}
