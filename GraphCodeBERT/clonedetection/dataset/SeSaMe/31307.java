public int getLocalPort() {
    if ( isClosed() ) {
        return -1;
    }
    try {
        return getImpl().getLocalPort();
    } catch ( Exception e ) {
        return 0;
    }
}
