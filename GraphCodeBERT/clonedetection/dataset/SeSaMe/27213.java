@SuppressWarnings ( "unchecked" )
final void signalEvent ( WatchEvent.Kind<?> kind, Object context ) {
    boolean isModify = ( kind == StandardWatchEventKinds.ENTRY_MODIFY );
    synchronized ( this ) {
        int size = events.size();
        if ( size > 0 ) {
            WatchEvent<?> prev = events.get ( size - 1 );
            if ( ( prev.kind() == StandardWatchEventKinds.OVERFLOW ) ||
                    ( ( kind == prev.kind() &&
                        Objects.equals ( context, prev.context() ) ) ) ) {
                ( ( Event<?> ) prev ).increment();
                return;
            }
            if ( !lastModifyEvents.isEmpty() ) {
                if ( isModify ) {
                    WatchEvent<?> ev = lastModifyEvents.get ( context );
                    if ( ev != null ) {
                        assert ev.kind() == StandardWatchEventKinds.ENTRY_MODIFY;
                        ( ( Event<?> ) ev ).increment();
                        return;
                    }
                } else {
                    lastModifyEvents.remove ( context );
                }
            }
            if ( size >= MAX_EVENT_LIST_SIZE ) {
                kind = StandardWatchEventKinds.OVERFLOW;
                isModify = false;
                context = null;
            }
        }
        Event<Object> ev =
            new Event<> ( ( WatchEvent.Kind<Object> ) kind, context );
        if ( isModify ) {
            lastModifyEvents.put ( context, ev );
        } else if ( kind == StandardWatchEventKinds.OVERFLOW ) {
            events.clear();
            lastModifyEvents.clear();
        }
        events.add ( ev );
        signal();
    }
}
