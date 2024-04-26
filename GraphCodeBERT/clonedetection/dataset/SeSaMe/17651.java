final long reserveAndGetWaitLength ( int permits, long nowMicros ) {
    long momentAvailable = reserveEarliestAvailable ( permits, nowMicros );
    return max ( momentAvailable - nowMicros, 0 );
}
