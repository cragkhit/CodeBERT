public Stream<Entry<CacheContext, Cache<Integer, Integer>>> generate() {
    return combinations().stream()
           .map ( this::newCacheContext )
           .filter ( this::isCompatible )
    .map ( context -> {
        Cache<Integer, Integer> cache = newCache ( context );
        populate ( context, cache );
        return Maps.immutableEntry ( context, cache );
    } );
}
