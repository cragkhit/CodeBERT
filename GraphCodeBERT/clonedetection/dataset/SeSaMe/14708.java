public synchronized void shutDown() throws TargetException {
    if ( this.process != null ) {
        this.process.destroy();
        this.process = null;
        cleanupTargetPath();
    }
}
