protected void removeLastFieldSeparator ( final StringBuffer buffer ) {
    final int len = buffer.length();
    final int sepLen = fieldSeparator.length();
    if ( len > 0 && sepLen > 0 && len >= sepLen ) {
        boolean match = true;
        for ( int i = 0; i < sepLen; i++ ) {
            if ( buffer.charAt ( len - 1 - i ) != fieldSeparator.charAt ( sepLen - 1 - i ) ) {
                match = false;
                break;
            }
        }
        if ( match ) {
            buffer.setLength ( len - sepLen );
        }
    }
}
