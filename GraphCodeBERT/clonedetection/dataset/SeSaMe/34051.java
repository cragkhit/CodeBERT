static void close ( int fd ) {
    if ( fd != -1 ) {
        close0 ( fd );
    }
}
