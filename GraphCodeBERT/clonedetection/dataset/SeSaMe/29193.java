public boolean contains ( Object o ) {
    if ( o == null ) {
        return false;
    }
    final ReentrantLock lock = this.lock;
    lock.lock();
    try {
        if ( count > 0 ) {
            final Object[] items = this.items;
            for ( int i = takeIndex, end = putIndex,
                    to = ( i < end ) ? end : items.length;
                    ; i = 0, to = end ) {
                for ( ; i < to; i++ )
                    if ( o.equals ( items[i] ) ) {
                        return true;
                    }
                if ( to == end ) {
                    break;
                }
            }
        }
        return false;
    } finally {
        lock.unlock();
    }
}
