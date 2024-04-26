@NonNull
public CacheStats minus ( @NonNull CacheStats other ) {
    return new CacheStats (
               Math.max ( 0L, hitCount - other.hitCount ),
               Math.max ( 0L, missCount - other.missCount ),
               Math.max ( 0L, loadSuccessCount - other.loadSuccessCount ),
               Math.max ( 0L, loadFailureCount - other.loadFailureCount ),
               Math.max ( 0L, totalLoadTime - other.totalLoadTime ),
               Math.max ( 0L, evictionCount - other.evictionCount ),
               Math.max ( 0L, evictionWeight - other.evictionWeight ) );
}
