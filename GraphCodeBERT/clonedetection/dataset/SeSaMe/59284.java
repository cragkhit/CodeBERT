public boolean reportDeprecated ( Environment env ) {
    return ( isDeprecated() || clazz.reportDeprecated ( env ) );
}
