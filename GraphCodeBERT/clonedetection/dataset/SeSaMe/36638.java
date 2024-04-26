public String simpleTypeName() {
    if ( simpleTypeName == null ) {
        simpleTypeName = tsym.name.toString();
    }
    return simpleTypeName;
}
