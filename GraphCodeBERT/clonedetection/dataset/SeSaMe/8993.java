public static String[] parseLine ( String line ) {
    boolean insideQuote = false;
    List<String> result = new ArrayList<>();
    StringBuilder builder = new StringBuilder();
    int quoteCount = 0;
    for ( int i = 0; i < line.length(); i++ ) {
        char c = line.charAt ( i );
        if ( c == QUOTE ) {
            insideQuote = !insideQuote;
            quoteCount++;
        }
        if ( c == COMMA && !insideQuote ) {
            String value = builder.toString();
            value = unescape ( value );
            result.add ( value );
            builder = new StringBuilder();
            continue;
        }
        builder.append ( c );
    }
    result.add ( builder.toString() );
    if ( quoteCount % 2 != 0 ) {
        throw new RuntimeException ( "Unmatched quote in entry: " + line );
    }
    return result.toArray ( new String[result.size()] );
}
