@Override
public void clear() {
    final E[] items = this.items;
    final Monitor monitor = this.monitor;
    monitor.enter();
    try {
        int i = takeIndex;
        int k = count;
        while ( k-- > 0 ) {
            items[i] = null;
            i = inc ( i );
        }
        count = 0;
        putIndex = 0;
        takeIndex = 0;
    } finally {
        monitor.leave();
    }
}
