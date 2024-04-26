public static void failCleanup ( IOException ex, String name ) {
    fail ( String.format ( ERROR_MSG_CLEANUP, name ), ex );
}
