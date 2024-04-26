public List<SourceMapping> getSourceMappings() {
    if ( sourceMapping.isEmpty() ) {
        return emptyList();
    }
    return unmodifiableList ( sourceMapping );
}
