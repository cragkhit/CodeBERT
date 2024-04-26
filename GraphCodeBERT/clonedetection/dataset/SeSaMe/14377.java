static IModuleDescription getModuleDescription ( IPackageFragmentRoot root, Map<IPackageFragmentRoot, IModuleDescription> cache, Function<IPackageFragmentRoot, IClasspathEntry> rootToEntry ) {
    IModuleDescription module = cache.get ( root );
    if ( module != null ) {
        return module != NO_MODULE ? module : null;
    }
    try {
        if ( root.getKind() == IPackageFragmentRoot.K_SOURCE ) {
            module = root.getJavaProject().getModuleDescription();    
        } else {
            module = root.getModuleDescription();
        }
    } catch ( JavaModelException e ) {
        cache.put ( root, NO_MODULE );
        return null;
    }
    if ( module == null ) {
        IClasspathEntry classpathEntry = rootToEntry.apply ( root );
        if ( classpathEntry instanceof ClasspathEntry ) {
            if ( ( ( ClasspathEntry ) classpathEntry ).isModular() ) {
                module = ( ( PackageFragmentRoot ) root ).getAutomaticModuleDescription ( classpathEntry );
            }
        }
    }
    cache.put ( root, module != null ? module : NO_MODULE );
    return module;
}
