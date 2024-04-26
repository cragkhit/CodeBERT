public static <K, V> Cache<K, V> newCache ( CacheContext context ) {
    switch ( context.implementation() ) {
    case Caffeine:
        return CaffeineCacheFromContext.newCaffeineCache ( context );
    case Guava:
        return GuavaCacheFromContext.newGuavaCache ( context );
    }
    throw new IllegalStateException();
}
