public CacheStats minus ( CacheStats other ) {
    return new CacheStats (
               Math.max ( 0, hitCount - other.hitCount ),
               Math.max ( 0, missCount - other.missCount ),
               Math.max ( 0, loadSuccessCount - other.loadSuccessCount ),
               Math.max ( 0, loadExceptionCount - other.loadExceptionCount ),
               Math.max ( 0, totalLoadTime - other.totalLoadTime ),
               Math.max ( 0, evictionCount - other.evictionCount ) );
}
