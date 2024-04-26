public static boolean containsTypeVariables ( final Type type ) {
    if ( type instanceof TypeVariable<?> ) {
        return true;
    }
    if ( type instanceof Class<?> ) {
        return ( ( Class<?> ) type ).getTypeParameters().length > 0;
    }
    if ( type instanceof ParameterizedType ) {
        for ( final Type arg : ( ( ParameterizedType ) type ).getActualTypeArguments() ) {
            if ( containsTypeVariables ( arg ) ) {
                return true;
            }
        }
        return false;
    }
    if ( type instanceof WildcardType ) {
        final WildcardType wild = ( WildcardType ) type;
        return containsTypeVariables ( getImplicitLowerBounds ( wild ) [0] )
               || containsTypeVariables ( getImplicitUpperBounds ( wild ) [0] );
    }
    return false;
}
