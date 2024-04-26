public boolean elementsEqual ( Element e1, Element e2 ) {
    if ( e1.getKind() != e2.getKind() ) {
        return false;
    }
    String s1 = getSimpleName ( e1 );
    String s2 = getSimpleName ( e2 );
    if ( compareStrings ( s1, s2 ) == 0 ) {
        String f1 = getFullyQualifiedName ( e1, true );
        String f2 = getFullyQualifiedName ( e2, true );
        return compareStrings ( f1, f2 ) == 0;
    }
    return false;
}
