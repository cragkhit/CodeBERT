public synchronized void reset() throws IOException {
    try {
        close();
    } finally {
        if ( memory == null ) {
            memory = new MemoryOutput();
        } else {
            memory.reset();
        }
        out = memory;
        if ( file != null ) {
            File deleteMe = file;
            file = null;
            if ( !deleteMe.delete() ) {
                throw new IOException ( "Could not delete: " + deleteMe );
            }
        }
    }
}
