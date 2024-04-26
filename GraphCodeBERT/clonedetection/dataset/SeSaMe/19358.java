public void incrementBy ( StatsCounter other ) {
    CacheStats otherStats = other.snapshot();
    hitCount.add ( otherStats.hitCount() );
    missCount.add ( otherStats.missCount() );
    loadSuccessCount.add ( otherStats.loadSuccessCount() );
    loadExceptionCount.add ( otherStats.loadExceptionCount() );
    totalLoadTime.add ( otherStats.totalLoadTime() );
    evictionCount.add ( otherStats.evictionCount() );
}
