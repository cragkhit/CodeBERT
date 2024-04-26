public static synchronized D3DRenderQueue getInstance() {
    if ( theInstance == null ) {
        theInstance = new D3DRenderQueue();
        theInstance.flushAndInvokeNow ( new Runnable() {
            public void run() {
                rqThread = Thread.currentThread();
            }
        } );
    }
    return theInstance;
}
