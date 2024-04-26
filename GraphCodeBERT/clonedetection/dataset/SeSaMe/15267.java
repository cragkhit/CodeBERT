public void testCheckedGetThrowsApplicationExceptionOnCancellation() {
    final CheckedFuture<Boolean, ?> future = createCheckedFuture ( Boolean.TRUE, null, latch );
    assertFalse ( future.isDone() );
    assertFalse ( future.isCancelled() );
    new Thread (
    new Runnable() {
        @Override
        public void run() {
            future.cancel ( true );
        }
    } )
    .start();
    try {
        future.checkedGet();
        fail ( "RPC Should have been cancelled." );
    } catch ( Exception e ) {
        checkCancelledException ( e );
    }
    assertTrue ( future.isDone() );
    assertTrue ( future.isCancelled() );
}
