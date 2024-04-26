public boolean isExcluded ( String fieldName ) {
    readFileIfNeeded();
    return methods.get ( fieldName ) != null;
}
