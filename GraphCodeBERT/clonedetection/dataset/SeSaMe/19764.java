public void enableVerbose ( boolean enable ) {
    if ( !verbose ) {
        flushLogBuffer();
    }
    verbose = enable;
}
