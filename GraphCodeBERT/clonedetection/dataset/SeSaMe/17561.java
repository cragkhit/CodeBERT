public int getWaitQueueLength ( Guard guard ) {
    if ( guard.monitor != this ) {
        throw new IllegalMonitorStateException();
    }
    lock.lock();
    try {
        return guard.waiterCount;
    } finally {
        lock.unlock();
    }
}
