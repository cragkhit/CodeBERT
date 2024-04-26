public char[][] getPackageNamesForClassFile() {
    if ( this.packageNames == null ) {
        return null;
    }
    for ( PackageBinding packageBinding : this.exportedPackages ) {
        this.packageNames.add ( packageBinding.readableName() );
    }
    for ( PackageBinding packageBinding : this.openedPackages ) {
        this.packageNames.add ( packageBinding.readableName() );
    }
    if ( this.implementations != null )
        for ( TypeBinding[] types : this.implementations.values() )
            for ( TypeBinding typeBinding : types ) {
                this.packageNames.add ( ( ( ReferenceBinding ) typeBinding ).fPackage.readableName() );
            }
    return this.packageNames.values;
}
