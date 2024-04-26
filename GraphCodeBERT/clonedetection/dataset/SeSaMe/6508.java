public void setIfFirst ( Throwable t ) {
    try {
        lock.writeLock().lock();
        if ( this.t == null ) {
            this.t = t;
        }
    } finally {
        lock.writeLock().unlock();
    }
}
