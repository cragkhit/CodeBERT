@Override
public boolean contains ( @Nullable Object o ) {
    final Monitor monitor = this.monitor;
    monitor.enter();
    try {
        return q.contains ( o );
    } finally {
        monitor.leave();
    }
}
