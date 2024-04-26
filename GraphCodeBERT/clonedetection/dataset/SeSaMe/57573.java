public synchronized String getMBeanServerId() {
    if ( mbeanServerId == null ) {
        String localHost;
        try {
            localHost = java.net.InetAddress.getLocalHost().getHostName();
        } catch ( java.net.UnknownHostException e ) {
            JmxProperties.MISC_LOGGER.log ( Level.TRACE,
                                            "Can't get local host name, " +
                                            "using \"localhost\" instead. Cause is: " + e );
            localHost = "localhost";
        }
        mbeanServerId = localHost + "_" + stamp;
    }
    return mbeanServerId;
}
