public static int getFreePort() {
    ServerSocket socket = null;
    try {
        socket = new ServerSocket ( 0 );
        return socket.getLocalPort();
    } catch ( IOException e ) {
    } finally {
        if ( socket != null ) {
            try {
                socket.close();
            } catch ( IOException e ) {
            }
        }
    }
    return -1;
}
