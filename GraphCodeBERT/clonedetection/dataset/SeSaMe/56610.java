RMIConnection doNewClient ( Object credentials ) throws IOException {
    final boolean tracing = logger.traceOn();
    if ( tracing ) {
        logger.trace ( "newClient", "making new client" );
    }
    if ( getMBeanServer() == null ) {
        throw new IllegalStateException ( "Not attached to an MBean server" );
    }
    Subject subject = null;
    JMXAuthenticator authenticator =
        ( JMXAuthenticator ) env.get ( JMXConnectorServer.AUTHENTICATOR );
    if ( authenticator == null ) {
        if ( env.get ( "jmx.remote.x.password.file" ) != null ||
                env.get ( "jmx.remote.x.login.config" ) != null ) {
            authenticator = new JMXPluggableAuthenticator ( env );
        }
    }
    if ( authenticator != null ) {
        if ( tracing ) logger.trace ( "newClient", "got authenticator: " +
                                          authenticator.getClass().getName() );
        try {
            subject = authenticator.authenticate ( credentials );
        } catch ( SecurityException e ) {
            logger.trace ( "newClient", "Authentication failed: " + e );
            throw e;
        }
    }
    if ( tracing ) {
        if ( subject != null ) {
            logger.trace ( "newClient", "subject is not null" );
        } else {
            logger.trace ( "newClient", "no subject" );
        }
    }
    final String connectionId = makeConnectionId ( getProtocol(), subject );
    if ( tracing ) {
        logger.trace ( "newClient", "making new connection: " + connectionId );
    }
    RMIConnection client = makeClient ( connectionId, subject );
    dropDeadReferences();
    WeakReference<RMIConnection> wr = new WeakReference<RMIConnection> ( client );
    synchronized ( clientList ) {
        clientList.add ( wr );
    }
    connServer.connectionOpened ( connectionId, "Connection opened", null );
    synchronized ( clientList ) {
        if ( !clientList.contains ( wr ) ) {
            throw new IOException ( "The connection is refused." );
        }
    }
    if ( tracing ) {
        logger.trace ( "newClient", "new connection done: " + connectionId );
    }
    return client;
}
