static void traceArgs ( final DebugLogger logger, final String tag, final int paramStart, final Object... args ) {
    final StringBuilder sb = new StringBuilder();
    sb.append ( tag );
    for ( int i = paramStart; i < args.length; i++ ) {
        if ( i == paramStart ) {
            sb.append ( " => args: " );
        }
        sb.append ( '\'' ).
        append ( stripName ( argString ( args[i] ) ) ).
        append ( '\'' ).
        append ( ' ' ).
        append ( '[' ).
        append ( "type=" ).
        append ( args[i] == null ? "null" : stripName ( args[i].getClass() ) ).
        append ( ']' );
        if ( i + 1 < args.length ) {
            sb.append ( ", " );
        }
    }
    if ( logger == null ) {
        err ( sb.toString() );
    } else {
        logger.log ( TRACE_LEVEL, sb );
    }
    stacktrace ( logger );
}
