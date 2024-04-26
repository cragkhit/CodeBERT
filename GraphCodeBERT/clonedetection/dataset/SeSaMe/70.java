@NonNegative
public double averageLoadPenalty() {
    long totalLoadCount = loadSuccessCount + loadFailureCount;
    return ( totalLoadCount == 0 )
           ? 0.0
           : ( double ) totalLoadTime / totalLoadCount;
}
