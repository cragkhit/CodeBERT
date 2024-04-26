public char[][] makeFeatureArr ( List<Element> list, int index ) {
    char[][] result = new char[template.length][];
    char[] chars = null;
    int len = 0;
    int i = 0;
    for ( ; i < template.length; i++ ) {
        if ( template[i].length == 0 ) {
            continue;
        }
        chars = new char[template[i].length + 1];
        len = chars.length - 1;
        for ( int j = 0; j < len; j++ ) {
            chars[j] = getNameIfOutArr ( list, index + template[i][j] );
        }
        chars[len] = ( char ) ( FEATURE_BEGIN + i );
        result[i] = chars;
    }
    return result;
}
