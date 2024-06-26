final @Nullable TypeToken<? super T> getGenericSuperclass() {
    if ( runtimeType instanceof TypeVariable ) {
        return boundAsSuperclass ( ( ( TypeVariable<?> ) runtimeType ).getBounds() [0] );
    }
    if ( runtimeType instanceof WildcardType ) {
        return boundAsSuperclass ( ( ( WildcardType ) runtimeType ).getUpperBounds() [0] );
    }
    Type superclass = getRawType().getGenericSuperclass();
    if ( superclass == null ) {
        return null;
    }
    @SuppressWarnings ( "unchecked" ) 
    TypeToken<? super T> superToken = ( TypeToken<? super T> ) resolveSupertype ( superclass );
    return superToken;
}
