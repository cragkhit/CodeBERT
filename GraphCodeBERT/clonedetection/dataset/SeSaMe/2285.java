synchronized void endOfPeriod() {
    lastCallsPerPeriod = acquireCount;
    totalAcquireCount += acquireCount;
    periodCount++;
    acquireCount = 0;
    notifyAll();
}
