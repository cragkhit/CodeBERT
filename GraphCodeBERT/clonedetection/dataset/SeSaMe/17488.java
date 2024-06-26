@Override
public void clear() {
    final Monitor monitor = this.monitor;
    monitor.enter();
    try {
        q.clear();
    } finally {
        monitor.leave();
    }
}
