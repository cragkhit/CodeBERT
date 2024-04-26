public synchronized void shutdown() {
    if ( stopLock.get() ) {
        return;
    }
    transport.shutdown();
    disposable.dispose();
    updaterParamsSubscribers.clear();
    modelParamsSubsribers.clear();
    updatesSubscribers.clear();
    updatesQueue.clear();
    launchLock.set ( false );
    stopLock.set ( true );
}
