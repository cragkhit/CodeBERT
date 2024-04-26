public static boolean isIdentifier ( String str ) {
    boolean isIdentifier = !str.isEmpty();
    for ( int i = 0; isIdentifier && i < str.length(); i++ ) {
        if ( i == 0 ) {
            isIdentifier = Character.isJavaIdentifierStart ( str.charAt ( 0 ) );
        } else {
            isIdentifier = Character.isJavaIdentifierPart ( str.charAt ( i ) );
        }
    }
    return isIdentifier;
}
