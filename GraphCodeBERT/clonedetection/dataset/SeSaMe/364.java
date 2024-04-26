static <K, V> LocalCache<K, V> toLocalCache ( Cache<K, V> cache ) {
    if ( cache instanceof LocalLoadingCache ) {
        return ( ( LocalLoadingCache<K, V> ) cache ).localCache;
    }
    throw new IllegalArgumentException ( "Cache of type " + cache.getClass()
                                         + " doesn't have a LocalCache." );
}
