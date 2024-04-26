public static String getProblemArgumentsForMarker ( String[] arguments ) {
    StringBuffer args = new StringBuffer ( 10 );
    args.append ( arguments.length );
    args.append ( ':' );
    for ( int j = 0; j < arguments.length; j++ ) {
        if ( j != 0 ) {
            args.append ( ARGUMENTS_DELIMITER );
        }
        if ( arguments[j].length() == 0 ) {
            args.append ( EMPTY_ARGUMENT );
        } else {
            encodeArgument ( arguments[j], args );
        }
    }
    return args.toString();
}
