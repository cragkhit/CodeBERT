public static String escapeAllControlChars ( String text ) {
    final String textWithoutNewlines = NEWLINE.matcher ( text ).replaceAll ( "\\\\n" );
    final String textWithoutReturns = RETURN.matcher ( textWithoutNewlines ).replaceAll ( "\\\\r" );
    return TAB.matcher ( textWithoutReturns ).replaceAll ( "\\\\t" );
}
