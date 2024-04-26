public List<AnnotationProcessorFactory> getJava5FactoriesForProject ( IJavaProject jproj ) {
    Map<AnnotationProcessorFactory, FactoryPath.Attributes> factoriesAndAttrs =
        getJava5FactoriesAndAttributesForProject ( jproj );
    final List<AnnotationProcessorFactory> factories =
        new ArrayList<> ( factoriesAndAttrs.keySet() );
    return Collections.unmodifiableList ( factories );
}
