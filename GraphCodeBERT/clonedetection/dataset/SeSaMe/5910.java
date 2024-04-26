protected void sweepTail() {
    Integer deviceId = allocator.getDeviceId();
    int cnt = 0;
    long lastCommandId = deviceClocks.get ( deviceId ).get();
    for ( int l = 0; l < configuration.getCommandLanesNumber(); l++ ) {
        Queue<cudaEvent_t> queue = eventsBarrier.get ( deviceId ).get ( l );
        if ( queue.size() >= MAX_EXECUTION_QUEUE
                || laneClocks.get ( deviceId ).get ( l ).get() < lastCommandId - MAX_EXECUTION_QUEUE ) {
            cudaEvent_t event = queue.poll();
            if ( event != null && !event.isDestroyed() ) {
                event.synchronize();
                event.destroy();
                cnt++;
            }
        }
    }
    deviceClocks.get ( deviceId ).incrementAndGet();
}
