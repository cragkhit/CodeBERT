public void setElementType ( Type type ) {
    unsupportedIn2_3_4();
    if ( type == null || type instanceof ArrayType ) {
        throw new IllegalArgumentException();
    }
    internalSetType ( type, ELEMENT_TYPE_PROPERTY );
}
