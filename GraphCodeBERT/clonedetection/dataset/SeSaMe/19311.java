public double averageLoadPenalty() {
    long totalLoadCount = loadSuccessCount + loadExceptionCount;
    return ( totalLoadCount == 0 ) ? 0.0 : ( double ) totalLoadTime / totalLoadCount;
}
