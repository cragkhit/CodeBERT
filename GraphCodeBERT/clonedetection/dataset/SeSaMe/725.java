public static double parseDouble ( String text, int type ) {
    String txt = UNDERSCORE_PATTERN.matcher ( text ).replaceAll ( "" );
    final double result;
    switch ( type ) {
    case TokenTypes.NUM_FLOAT:
    case TokenTypes.NUM_DOUBLE:
        result = Double.parseDouble ( txt );
        break;
    case TokenTypes.NUM_INT:
    case TokenTypes.NUM_LONG:
        int radix = BASE_10;
        if ( txt.startsWith ( "0x" ) || txt.startsWith ( "0X" ) ) {
            radix = BASE_16;
            txt = txt.substring ( 2 );
        } else if ( txt.startsWith ( "0b" ) || txt.startsWith ( "0B" ) ) {
            radix = BASE_2;
            txt = txt.substring ( 2 );
        } else if ( CommonUtil.startsWithChar ( txt, '0' ) ) {
            radix = BASE_8;
            txt = txt.substring ( 1 );
        }
        result = parseNumber ( txt, radix, type );
        break;
    default:
        result = Double.NaN;
        break;
    }
    return result;
}
