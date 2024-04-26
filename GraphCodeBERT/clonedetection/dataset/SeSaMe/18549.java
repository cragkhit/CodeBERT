final void dispatchEvent ( final Object event ) {
    executor.execute (
    new Runnable() {
        @Override
        public void run() {
            try {
                invokeSubscriberMethod ( event );
            } catch ( InvocationTargetException e ) {
                bus.handleSubscriberException ( e.getCause(), context ( event ) );
            }
        }
    } );
}
