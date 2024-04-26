public static Set<String> getPackageNames ( ClassLoader classLoader )
throws CheckstyleException {
    final Set<String> result;
    try {
        final PackageNamesLoader namesLoader = new PackageNamesLoader();
        final Enumeration<URL> packageFiles = classLoader.getResources ( CHECKSTYLE_PACKAGES );
        while ( packageFiles.hasMoreElements() ) {
            processFile ( packageFiles.nextElement(), namesLoader );
        }
        result = namesLoader.packageNames;
    } catch ( IOException ex ) {
        throw new CheckstyleException ( "unable to get package file resources", ex );
    } catch ( ParserConfigurationException | SAXException ex ) {
        throw new CheckstyleException ( "unable to open one of package files", ex );
    }
    return result;
}
