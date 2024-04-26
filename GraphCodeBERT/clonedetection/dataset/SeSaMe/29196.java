public void clear() {
    final ReentrantLock lock = this.lock;
    lock.lock();
    try {
        int k;
        if ( ( k = count ) > 0 ) {
            circularClear ( items, takeIndex, putIndex );
            takeIndex = putIndex;
            count = 0;
            if ( itrs != null ) {
                itrs.queueIsEmpty();
            }
            for ( ; k > 0 && lock.hasWaiters ( notFull ); k-- ) {
                notFull.signal();
            }
        }
    } finally {
        lock.unlock();
    }
}
