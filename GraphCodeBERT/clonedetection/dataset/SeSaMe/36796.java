public PackageDocImpl getPackageDoc ( PackageSymbol pack ) {
    PackageDocImpl result = packageMap.get ( pack );
    if ( result != null ) {
        return result;
    }
    result = new PackageDocImpl ( this, pack );
    packageMap.put ( pack, result );
    return result;
}
