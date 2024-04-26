public synchronized static BufferManager getDefaultBufferManager() {
    if ( DEFAULT_BUFFER_MANAGER == null ) {
        DEFAULT_BUFFER_MANAGER = new BufferManager();
    }
    return DEFAULT_BUFFER_MANAGER;
}
