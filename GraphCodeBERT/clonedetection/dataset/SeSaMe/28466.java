public boolean contains ( Object o ) {
    final ReentrantLock lock = this.lock;
    lock.lock();
    try {
        return indexOf ( o ) != -1;
    } finally {
        lock.unlock();
    }
}
