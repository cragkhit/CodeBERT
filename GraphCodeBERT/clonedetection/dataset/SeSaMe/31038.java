public boolean ready() throws IOException {
    synchronized ( lock ) {
        ensureOpen();
        return ( pos < buf.length ) || super.ready();
    }
}
