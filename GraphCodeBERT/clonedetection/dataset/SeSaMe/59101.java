public void calculateDependents() {
    dependents = new HashMap<>();
    for ( String s : packages.keySet() ) {
        Package p = packages.get ( s );
        Set<String> deps = p.typeDependencies()  
                           .values()
                           .stream()
                           .reduce ( Collections.emptySet(), Util::union );
        for ( String dep : deps ) {
            String depPkgStr = ":" + dep.substring ( 0, dep.lastIndexOf ( '.' ) );
            dependents.merge ( depPkgStr, Collections.singleton ( s ), Util::union );
            Package dp = packages.get ( depPkgStr );
            if ( dp != null ) {
                dp.addDependent ( p.name() );
            }
        }
    }
}
