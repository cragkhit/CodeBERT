public void printColumns ( final Collection<? extends CharSequence> items ) throws IOException {
    if ( items == null || items.isEmpty() ) {
        return;
    }
    int width = getTerminal().getWidth();
    int height = getTerminal().getHeight();
    int maxWidth = 0;
    for ( CharSequence item : items ) {
        int len = wcwidth ( Ansi.stripAnsi ( item.toString() ), 0 );
        maxWidth = Math.max ( maxWidth, len );
    }
    maxWidth = maxWidth + 3;
    Log.debug ( "Max width: ", maxWidth );
    int showLines;
    if ( isPaginationEnabled() ) {
        showLines = height - 1; 
    } else {
        showLines = Integer.MAX_VALUE;
    }
    StringBuilder buff = new StringBuilder();
    int realLength = 0;
    for ( CharSequence item : items ) {
        if ( ( realLength + maxWidth ) > width ) {
            rawPrintln ( buff.toString() );
            buff.setLength ( 0 );
            realLength = 0;
            if ( --showLines == 0 ) {
                print ( resources.getString ( "DISPLAY_MORE" ) );
                flush();
                int c = readCharacter();
                if ( c == '\r' || c == '\n' ) {
                    showLines = 1;
                } else if ( c != 'q' ) {
                    showLines = height - 1;
                }
                tputs ( "carriage_return" );
                if ( c == 'q' ) {
                    break;
                }
            }
        }
        buff.append ( item.toString() );
        int strippedItemLength = wcwidth ( Ansi.stripAnsi ( item.toString() ), 0 );
        for ( int i = 0; i < ( maxWidth - strippedItemLength ); i++ ) {
            buff.append ( ' ' );
        }
        realLength += maxWidth;
    }
    if ( buff.length() > 0 ) {
        rawPrintln ( buff.toString() );
    }
}
