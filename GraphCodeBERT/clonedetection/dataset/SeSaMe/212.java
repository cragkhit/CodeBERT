@Override
public boolean containsValue ( Object value ) {
    if ( value == null ) {
        throw new NullPointerException();
    }
    final Segment<K, V>[] segments = this.segments;
    boolean found = false;
    long last = 0;
    int retries = -1;
    try {
        outer: for ( ;; ) {
            if ( retries++ == RETRIES_BEFORE_LOCK ) {
                for ( int j = 0; j < segments.length; ++j ) {
                    ensureSegment ( j ).lock(); 
                }
            }
            long hashSum = 0L;
            int sum = 0;
            for ( int j = 0; j < segments.length; ++j ) {
                HashEntry<K, V>[] tab;
                Segment<K, V> seg = segmentAt ( segments, j );
                if ( seg != null && ( tab = seg.table ) != null ) {
                    for ( int i = 0 ; i < tab.length; i++ ) {
                        HashEntry<K, V> e;
                        for ( e = entryAt ( tab, i ); e != null; e = e.next ) {
                            V v = e.value;
                            if ( v != null && value.equals ( v ) ) {
                                found = true;
                                break outer;
                            }
                        }
                    }
                    sum += seg.modCount;
                }
            }
            if ( retries > 0 && sum == last ) {
                break;
            }
            last = sum;
        }
    } finally {
        if ( retries > RETRIES_BEFORE_LOCK ) {
            for ( int j = 0; j < segments.length; ++j ) {
                segmentAt ( segments, j ).unlock();
            }
        }
    }
    return found;
}
