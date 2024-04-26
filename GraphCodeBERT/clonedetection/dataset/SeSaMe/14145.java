protected void notifyChanged ( final BufferChangedEvent event ) {
    ListenerList<IBufferChangedListener> listeners = this.changeListeners;
    if ( listeners != null ) {
        Iterator<IBufferChangedListener> iterator = listeners.iterator();
        while ( iterator.hasNext() ) {
            final IBufferChangedListener listener = iterator.next();
            SafeRunner.run ( new ISafeRunnable() {
                @Override
                public void handleException ( Throwable exception ) {
                    Util.log ( exception, "Exception occurred in listener of buffer change notification" ); 
                }
                @Override
                public void run() throws Exception {
                    listener.bufferChanged ( event );
                }
            } );
        }
    }
}
