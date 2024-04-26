public static long getServerConnectionTimeout ( Map<String, ?> env ) {
    return getIntegerAttribute ( env, SERVER_CONNECTION_TIMEOUT, 120000L,
                                 0, Long.MAX_VALUE );
}
