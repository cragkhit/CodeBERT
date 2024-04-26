protected int getChildSpecificity ( String selector ) {
    char    firstChar = selector.charAt ( 0 );
    int     specificity = getSpecificity();
    if ( firstChar == '.' ) {
        specificity += 100;
    } else if ( firstChar == '#' ) {
        specificity += 10000;
    } else {
        specificity += 1;
        if ( selector.indexOf ( '.' ) != -1 ) {
            specificity += 100;
        }
        if ( selector.indexOf ( '#' ) != -1 ) {
            specificity += 10000;
        }
    }
    return specificity;
}
