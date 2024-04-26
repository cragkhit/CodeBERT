public synchronized void postReconnection ( ClientListenerInfo[] listenerInfos )
throws IOException {
    if ( state == TERMINATED ) {
        return;
    }
    while ( state == STOPPING ) {
        try {
            wait();
        } catch ( InterruptedException ire ) {
            IOException ioe = new IOException ( ire.toString() );
            EnvHelp.initCause ( ioe, ire );
            throw ioe;
        }
    }
    final boolean trace = logger.traceOn();
    final int len   = listenerInfos.length;
    for ( int i = 0; i < len; i++ ) {
        if ( trace ) {
            logger.trace ( "addNotificationListeners",
                           "Add a listener at " +
                           listenerInfos[i].getListenerID() );
        }
        infoList.put ( listenerInfos[i].getListenerID(), listenerInfos[i] );
    }
    beingReconnected = false;
    notifyAll();
    if ( currentFetchThread == Thread.currentThread() ||
            state == STARTING || state == STARTED ) { 
        try {
            mbeanRemovedNotifID = addListenerForMBeanRemovedNotif();
        } catch ( Exception e ) {
            final String msg =
                "Failed to register a listener to the mbean " +
                "server: the client will not do clean when an MBean " +
                "is unregistered";
            if ( logger.traceOn() ) {
                logger.trace ( "init", msg, e );
            }
        }
    } else {
        while ( state == STOPPING ) {
            try {
                wait();
            } catch ( InterruptedException ire ) {
                IOException ioe = new IOException ( ire.toString() );
                EnvHelp.initCause ( ioe, ire );
                throw ioe;
            }
        }
        if ( listenerInfos.length > 0 ) { 
            init ( true ); 
        } else if ( infoList.size() > 0 ) { 
            init ( false ); 
        }
    }
}
