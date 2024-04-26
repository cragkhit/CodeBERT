@Override
public int size() {
    final Monitor monitor = this.monitor;
    monitor.enter();
    try {
        return count;
    } finally {
        monitor.leave();
    }
}
