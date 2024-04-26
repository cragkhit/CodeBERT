public R visitVariable ( VariableElement e, P p ) {
    if ( e.getKind() != ElementKind.RESOURCE_VARIABLE ) {
        return defaultAction ( e, p );
    } else {
        return visitUnknown ( e, p );
    }
}
