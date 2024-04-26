public static TesterRequirements buildDeclaredTesterRequirements ( AnnotatedElement classOrMethod )
throws ConflictingRequirementsException {
    TesterRequirements requirements = new TesterRequirements();
    Iterable<Annotation> testerAnnotations = getTesterAnnotations ( classOrMethod );
    for ( Annotation testerAnnotation : testerAnnotations ) {
        TesterRequirements moreRequirements = buildTesterRequirements ( testerAnnotation );
        incorporateRequirements ( requirements, moreRequirements, testerAnnotation );
    }
    return requirements;
}
