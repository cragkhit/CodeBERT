public void put ( E e ) throws InterruptedException {
    Objects.requireNonNull ( e );
    final ReentrantLock lock = this.lock;
    lock.lockInterruptibly();
    try {
        while ( count == items.length ) {
            notFull.await();
        }
        enqueue ( e );
    } finally {
        lock.unlock();
    }
}
