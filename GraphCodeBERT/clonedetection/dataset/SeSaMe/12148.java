@Override
public ITypeAnnotationWalker toSupertype ( short index, char[] superTypeSignature ) {
    long newMatches = this.matches;
    if ( newMatches == 0 ) {
        return EMPTY_ANNOTATION_WALKER;
    }
    int length = this.typeAnnotations.length;
    long mask = 1;
    for ( int i = 0; i < length; i++, mask = mask << 1 ) {
        IBinaryTypeAnnotation candidate = this.typeAnnotations[i];
        if ( candidate.getTargetType() != AnnotationTargetTypeConstants.CLASS_EXTENDS || ( short ) candidate.getSupertypeIndex() != index ) {
            newMatches &= ~mask;
        }
    }
    return restrict ( newMatches, 0 );
}
