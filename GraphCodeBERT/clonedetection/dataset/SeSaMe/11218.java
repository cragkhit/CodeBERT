public TypeBinding substitute ( TypeBinding originalType ) {
    if ( ( originalType.tagBits & TagBits.HasTypeVariable ) != 0 ) {
        if ( originalType.isTypeVariable() ) {
            TypeVariableBinding originalVariable = ( TypeVariableBinding ) originalType;
            TypeVariableBinding[] variables = this.originalMethod.typeVariables;
            int length = variables.length;
            if ( originalVariable.rank < length && variables[originalVariable.rank] == originalVariable ) {
                return this.typeArguments[originalVariable.rank];
            }
        } else if ( originalType.isParameterizedType() ) {
            ParameterizedTypeBinding originalParameterizedType = ( ParameterizedTypeBinding ) originalType;
            TypeBinding[] originalArguments = originalParameterizedType.arguments;
            TypeBinding[] substitutedArguments = Scope.substitute ( this, originalArguments );
            if ( substitutedArguments != originalArguments ) {
                identicalVariables: { 
                    TypeVariableBinding[] originalVariables = originalParameterizedType.type.typeVariables();
                    for ( int i = 0, length = originalVariables.length; i < length; i++ ) {
                        if ( substitutedArguments[i] != originalVariables[i] ) {
                            break identicalVariables;
                        }
                    }
                    return originalParameterizedType.type;
                }
                return this.environment.createParameterizedType (
                           originalParameterizedType.type, substitutedArguments, originalParameterizedType.enclosingType() );
            }
        } else if ( originalType.isArrayType() ) {
            TypeBinding originalLeafComponentType = originalType.leafComponentType();
            TypeBinding substitute = substitute ( originalLeafComponentType ); 
            if ( substitute != originalLeafComponentType ) {
                return this.environment.createArrayType ( substitute.leafComponentType(), substitute.dimensions() + originalType.dimensions() );
            }
        } else if ( originalType.isWildcard() ) {
            WildcardBinding wildcard = ( WildcardBinding ) originalType;
            if ( wildcard.kind != Wildcard.UNBOUND ) {
                TypeBinding originalBound = wildcard.bound;
                TypeBinding substitutedBound = substitute ( originalBound );
                if ( substitutedBound != originalBound ) {
                    return this.environment.createWildcard ( wildcard.genericType, wildcard.rank, substitutedBound, wildcard.kind );
                }
            }
        }
    } else if ( originalType.isGenericType() ) {
        ReferenceBinding originalGenericType = ( ReferenceBinding ) originalType;
        TypeVariableBinding[] originalVariables = originalGenericType.typeVariables();
        int length = originalVariables.length;
        TypeBinding[] originalArguments;
        System.arraycopy ( originalVariables, 0, originalArguments = new TypeBinding[length], 0, length );
        TypeBinding[] substitutedArguments = Scope.substitute ( this, originalArguments );
        if ( substitutedArguments != originalArguments ) {
            return this.environment.createParameterizedType (
                       originalGenericType, substitutedArguments, null );
        }
    }
    return originalType;
}
