public void incrementBy ( @NonNull StatsCounter other ) {
    CacheStats otherStats = other.snapshot();
    hitCount.add ( otherStats.hitCount() );
    missCount.add ( otherStats.missCount() );
    loadSuccessCount.add ( otherStats.loadSuccessCount() );
    loadFailureCount.add ( otherStats.loadFailureCount() );
    totalLoadTime.add ( otherStats.totalLoadTime() );
    evictionCount.add ( otherStats.evictionCount() );
    evictionWeight.add ( otherStats.evictionWeight() );
}
