public static double parseFloat ( final Object self, final Object string ) {
    final String str    = JSType.trimLeft ( JSType.toString ( string ) );
    final int    length = str.length();
    if ( length == 0 ) {
        return Double.NaN;
    }
    int     start    = 0;
    boolean negative = false;
    char    ch       = str.charAt ( 0 );
    if ( ch == '-' ) {
        start++;
        negative = true;
    } else if ( ch == '+' ) {
        start++;
    } else if ( ch == 'N' ) {
        if ( str.startsWith ( "NaN" ) ) {
            return Double.NaN;
        }
    }
    if ( start == length ) {
        return Double.NaN;
    }
    ch = str.charAt ( start );
    if ( ch == 'I' ) {
        if ( str.substring ( start ).startsWith ( "Infinity" ) ) {
            return negative ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
        }
    }
    boolean dotSeen    = false;
    boolean exponentOk = false;
    int exponentOffset = -1;
    int end;
    loop:
    for ( end = start; end < length; end++ ) {
        ch = str.charAt ( end );
        switch ( ch ) {
        case '.':
            if ( exponentOffset != -1 || dotSeen ) {
                break loop;
            }
            dotSeen = true;
            break;
        case 'e':
        case 'E':
            if ( exponentOffset != -1 ) {
                break loop;
            }
            exponentOffset = end;
            break;
        case '+':
        case '-':
            if ( exponentOffset != end - 1 ) {
                break loop;
            }
            break;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            if ( exponentOffset != -1 ) {
                exponentOk = true;
            }
            break;
        default: 
            break loop;
        }
    }
    if ( exponentOffset != -1 && !exponentOk ) {
        end = exponentOffset;
    }
    if ( start == end ) {
        return Double.NaN;
    }
    try {
        final double result = Double.valueOf ( str.substring ( start, end ) );
        return negative ? -result : result;
    } catch ( final NumberFormatException e ) {
        return Double.NaN;
    }
}
