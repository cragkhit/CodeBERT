@Override
WatchKey register ( final Path path,
                    WatchEvent.Kind<?>[] events,
                    WatchEvent.Modifier... modifiers )
throws IOException {
    final Set<WatchEvent.Kind<?>> eventSet = new HashSet<> ( events.length );
    for ( WatchEvent.Kind<?> event : events ) {
        if ( event == StandardWatchEventKinds.ENTRY_CREATE ||
                event == StandardWatchEventKinds.ENTRY_MODIFY ||
                event == StandardWatchEventKinds.ENTRY_DELETE ) {
            eventSet.add ( event );
            continue;
        }
        if ( event == StandardWatchEventKinds.OVERFLOW ) {
            continue;
        }
        if ( event == null ) {
            throw new NullPointerException ( "An element in event set is 'null'" );
        }
        throw new UnsupportedOperationException ( event.name() );
    }
    if ( eventSet.isEmpty() ) {
        throw new IllegalArgumentException ( "No events to register" );
    }
    int sensitivity = 10;
    if ( modifiers.length > 0 ) {
        for ( WatchEvent.Modifier modifier : modifiers ) {
            if ( modifier == null ) {
                throw new NullPointerException();
            }
            if ( ExtendedOptions.SENSITIVITY_HIGH.matches ( modifier ) ) {
                sensitivity = ExtendedOptions.SENSITIVITY_HIGH.parameter();
            } else if ( ExtendedOptions.SENSITIVITY_MEDIUM.matches ( modifier ) ) {
                sensitivity = ExtendedOptions.SENSITIVITY_MEDIUM.parameter();
            } else if ( ExtendedOptions.SENSITIVITY_LOW.matches ( modifier ) ) {
                sensitivity = ExtendedOptions.SENSITIVITY_LOW.parameter();
            } else {
                throw new UnsupportedOperationException ( "Modifier not supported" );
            }
        }
    }
    if ( !isOpen() ) {
        throw new ClosedWatchServiceException();
    }
    try {
        int value = sensitivity;
        return AccessController.doPrivileged (
        new PrivilegedExceptionAction<PollingWatchKey>() {
            @Override
            public PollingWatchKey run() throws IOException {
                return doPrivilegedRegister ( path, eventSet, value );
            }
        } );
    } catch ( PrivilegedActionException pae ) {
        Throwable cause = pae.getCause();
        if ( cause != null && cause instanceof IOException ) {
            throw ( IOException ) cause;
        }
        throw new AssertionError ( pae );
    }
}
