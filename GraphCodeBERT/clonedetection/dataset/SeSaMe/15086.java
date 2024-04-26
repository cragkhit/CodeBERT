public static String decode ( String text ) {
    if ( text == null ) {
        return null;
    }
    StringBuilder buf = new StringBuilder ( text.length() );
    final int limit = text.length();
    for ( int i = 0; i < limit; i++ ) {
        char ch = text.charAt ( i );
        if ( ch != '\\' ) {
            buf.append ( ch );
            continue;
        }
        if ( ++i >= limit )
            throw new IllegalArgumentException (
                "illegal trailing '\\' in encoded string" );
        ch = text.charAt ( i );
        if ( ch == '\\' ) {
            buf.append ( ch );
            continue;
        }
        if ( ch != 'u' )
            throw new IllegalArgumentException (
                "illegal escape sequence '\\" + ch
                + "' in encoded string" );
        int value = 0;
        for ( int j = 0; j < 4; j++ ) {
            if ( ++i >= limit )
                throw new IllegalArgumentException (
                    "illegal truncated '\\u' escape sequence in encoded string" );
            int nibble = Character.digit ( text.charAt ( i ), 16 );
            if ( nibble == -1 ) {
                throw new IllegalArgumentException (
                    "illegal escape sequence '"
                    + text.substring ( i - j - 2, i - j + 4 )
                    + "' in encoded string" );
            }
            value = ( value << 4 ) | nibble;
        }
        buf.append ( ( char ) value );
    }
    return buf.toString();
}
