public void clear() {
    final ReentrantLock lock = this.lock;
    lock.lock();
    try {
        final Object[] es = queue;
        for ( int i = 0, n = size; i < n; i++ ) {
            es[i] = null;
        }
        size = 0;
    } finally {
        lock.unlock();
    }
}
