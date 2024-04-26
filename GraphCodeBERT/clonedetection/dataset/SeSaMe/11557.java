public synchronized boolean wasSuccessful() {
    return failureCount() == 0 && errorCount() == 0;
}
