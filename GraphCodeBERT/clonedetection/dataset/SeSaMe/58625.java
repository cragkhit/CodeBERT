KindSelector attribArgs ( KindSelector initialKind, List<JCExpression> trees, Env<AttrContext> env, ListBuffer<Type> argtypes ) {
    KindSelector kind = initialKind;
    for ( JCExpression arg : trees ) {
        Type argtype = chk.checkNonVoid ( arg, attribTree ( arg, env, allowPoly ? methodAttrInfo : unknownExprInfo ) );
        if ( argtype.hasTag ( DEFERRED ) ) {
            kind = KindSelector.of ( KindSelector.POLY, kind );
        }
        argtypes.append ( argtype );
    }
    return kind;
}
