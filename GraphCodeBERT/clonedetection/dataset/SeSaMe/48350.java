public Object get ( final String key ) {
    final int len = key.length();
    if ( m_charBuffer.length < len ) {
        return null;
    }
    Node node = m_Root;
    switch ( len ) { 
    case 0 : {
        return null;
    }
    case 1 : {
        final char ch = key.charAt ( 0 );
        if ( ch < ALPHA_SIZE ) {
            node = node.m_nextChar[ch];
            if ( node != null ) {
                return node.m_Value;
            }
        }
        return null;
    }
    default : {
        key.getChars ( 0, len, m_charBuffer, 0 );
        for ( int i = 0; i < len; i++ ) {
            final char ch = m_charBuffer[i];
            if ( ALPHA_SIZE <= ch ) {
                return null;
            }
            node = node.m_nextChar[ch];
            if ( node == null ) {
                return null;
            }
        }
        return node.m_Value;
    }
    }
}
