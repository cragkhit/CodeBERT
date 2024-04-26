@Override
public void put ( E e ) throws InterruptedException {
    if ( e == null ) {
        throw new NullPointerException();
    }
    final Monitor monitor = this.monitor;
    monitor.enterWhen ( notFull );
    try {
        insert ( e );
    } finally {
        monitor.leave();
    }
}
