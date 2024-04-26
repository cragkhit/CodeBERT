public void generateSyntheticBodyForConstructorAccess ( SyntheticMethodBinding accessBinding ) {
    initializeMaxLocals ( accessBinding );
    MethodBinding constructorBinding = accessBinding.targetMethod;
    TypeBinding[] parameters = constructorBinding.parameters;
    int length = parameters.length;
    int resolvedPosition = 1;
    aload_0();
    TypeBinding declaringClass = constructorBinding.declaringClass;
    if ( declaringClass.erasure().id == TypeIds.T_JavaLangEnum || declaringClass.isEnum() ) {
        aload_1(); 
        iload_2(); 
        resolvedPosition += 2;
    }
    if ( declaringClass.isNestedType() ) {
        NestedTypeBinding nestedType = ( NestedTypeBinding ) declaringClass;
        SyntheticArgumentBinding[] syntheticArguments = nestedType.syntheticEnclosingInstances();
        for ( int i = 0; i < ( syntheticArguments == null ? 0 : syntheticArguments.length ); i++ ) {
            TypeBinding type;
            load ( ( type = syntheticArguments[i].type ), resolvedPosition );
            switch ( type.id ) {
            case TypeIds.T_long :
            case TypeIds.T_double :
                resolvedPosition += 2;
                break;
            default :
                resolvedPosition++;
                break;
            }
        }
    }
    for ( int i = 0; i < length; i++ ) {
        TypeBinding parameter;
        load ( parameter = parameters[i], resolvedPosition );
        switch ( parameter.id ) {
        case TypeIds.T_long :
        case TypeIds.T_double :
            resolvedPosition += 2;
            break;
        default :
            resolvedPosition++;
            break;
        }
    }
    if ( declaringClass.isNestedType() ) {
        NestedTypeBinding nestedType = ( NestedTypeBinding ) declaringClass;
        SyntheticArgumentBinding[] syntheticArguments = nestedType.syntheticOuterLocalVariables();
        for ( int i = 0; i < ( syntheticArguments == null ? 0 : syntheticArguments.length ); i++ ) {
            TypeBinding type;
            load ( type = syntheticArguments[i].type, resolvedPosition );
            switch ( type.id ) {
            case TypeIds.T_long :
            case TypeIds.T_double :
                resolvedPosition += 2;
                break;
            default :
                resolvedPosition++;
                break;
            }
        }
    }
    invoke ( Opcodes.OPC_invokespecial, constructorBinding, null   );
    return_();
}
