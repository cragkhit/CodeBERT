public void validateAnnotations ( List<JCAnnotation> annotations, Symbol s ) {
    for ( JCAnnotation a : annotations ) {
        validateAnnotation ( a, s );
    }
}
