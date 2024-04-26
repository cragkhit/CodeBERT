protected Socket doConnect ( String server, int port )
throws IOException, UnknownHostException {
    Socket s;
    if ( proxy != null ) {
        if ( proxy.type() == Proxy.Type.SOCKS ) {
            s = AccessController.doPrivileged (
            new PrivilegedAction<>() {
                public Socket run() {
                    return new Socket ( proxy );
                }
            } );
        } else if ( proxy.type() == Proxy.Type.DIRECT ) {
            s = createSocket();
        } else {
            s = new Socket ( Proxy.NO_PROXY );
        }
    } else {
        s = createSocket();
    }
    if ( connectTimeout >= 0 ) {
        s.connect ( new InetSocketAddress ( server, port ), connectTimeout );
    } else {
        if ( defaultConnectTimeout > 0 ) {
            s.connect ( new InetSocketAddress ( server, port ), defaultConnectTimeout );
        } else {
            s.connect ( new InetSocketAddress ( server, port ) );
        }
    }
    if ( readTimeout >= 0 ) {
        s.setSoTimeout ( readTimeout );
    } else if ( defaultSoTimeout > 0 ) {
        s.setSoTimeout ( defaultSoTimeout );
    }
    return s;
}
