static Function<String, ClassLoader> mappingFunction ( Configuration cf ) {
    Set<String> bootModules = bootModules();
    Set<String> platformModules = platformModules();
    ClassLoader platformClassLoader = ClassLoaders.platformClassLoader();
    ClassLoader appClassLoader = ClassLoaders.appClassLoader();
    Map<String, ClassLoader> map = new HashMap<>();
    for ( ResolvedModule resolvedModule : cf.modules() ) {
        String mn = resolvedModule.name();
        if ( !bootModules.contains ( mn ) ) {
            if ( platformModules.contains ( mn ) ) {
                map.put ( mn, platformClassLoader );
            } else {
                map.put ( mn, appClassLoader );
            }
        }
    }
    return new Mapper ( map );
}
