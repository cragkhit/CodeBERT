Set<String> getResourceKeys() {
    Module jdk_javadoc = ModuleLayer.boot().findModule ( "jdk.javadoc" ).get();
    String[] names = {
        "com.sun.tools.javadoc.resources.javadoc",
    };
    Set<String> results = new TreeSet<String>();
    for ( String name : names ) {
        ResourceBundle b = ResourceBundle.getBundle ( name, jdk_javadoc );
        results.addAll ( b.keySet() );
    }
    return results;
}
