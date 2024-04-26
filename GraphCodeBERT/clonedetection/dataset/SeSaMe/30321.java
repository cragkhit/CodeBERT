public String toPattern() {
    StringBuilder result = new StringBuilder();
    for ( int i = 0; i < choiceLimits.length; ++i ) {
        if ( i != 0 ) {
            result.append ( '|' );
        }
        double less = previousDouble ( choiceLimits[i] );
        double tryLessOrEqual = Math.abs ( Math.IEEEremainder ( choiceLimits[i], 1.0d ) );
        double tryLess = Math.abs ( Math.IEEEremainder ( less, 1.0d ) );
        if ( tryLessOrEqual < tryLess ) {
            result.append ( choiceLimits[i] );
            result.append ( '#' );
        } else {
            if ( choiceLimits[i] == Double.POSITIVE_INFINITY ) {
                result.append ( "\u221E" );
            } else if ( choiceLimits[i] == Double.NEGATIVE_INFINITY ) {
                result.append ( "-\u221E" );
            } else {
                result.append ( less );
            }
            result.append ( '<' );
        }
        String text = choiceFormats[i];
        boolean needQuote = text.indexOf ( '<' ) >= 0
                            || text.indexOf ( '#' ) >= 0
                            || text.indexOf ( '\u2264' ) >= 0
                            || text.indexOf ( '|' ) >= 0;
        if ( needQuote ) {
            result.append ( '\'' );
        }
        if ( text.indexOf ( '\'' ) < 0 ) {
            result.append ( text );
        } else {
            for ( int j = 0; j < text.length(); ++j ) {
                char c = text.charAt ( j );
                result.append ( c );
                if ( c == '\'' ) {
                    result.append ( c );
                }
            }
        }
        if ( needQuote ) {
            result.append ( '\'' );
        }
    }
    return result.toString();
}
