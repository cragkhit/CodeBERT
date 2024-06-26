@Override
public boolean contains ( @Nullable Object o ) {
    if ( o == null ) {
        return false;
    }
    final E[] items = this.items;
    final Monitor monitor = this.monitor;
    monitor.enter();
    try {
        int i = takeIndex;
        int k = 0;
        while ( k++ < count ) {
            if ( o.equals ( items[i] ) ) {
                return true;
            }
            i = inc ( i );
        }
        return false;
    } finally {
        monitor.leave();
    }
}
