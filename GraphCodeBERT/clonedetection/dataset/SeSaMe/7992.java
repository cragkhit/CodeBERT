@Override
public void reset() {
    buffer.clear();
    if ( thread != null ) {
        thread.interrupt();
    }
    try {
        if ( thread != null ) {
            thread.join();
        }
    } catch ( InterruptedException e ) {
        Thread.currentThread().interrupt();
        throw new RuntimeException ( e );
    }
    thread.shutdown();
    buffer.clear();
    backedIterator.reset();
    shouldWork.set ( true );
    this.thread = new AsyncPrefetchThread ( buffer, backedIterator, terminator );
    Nd4j.getAffinityManager().attachThreadToDevice ( thread, deviceId );
    thread.setDaemon ( true );
    thread.start();
    hasDepleted.set ( false );
    nextElement = null;
}
