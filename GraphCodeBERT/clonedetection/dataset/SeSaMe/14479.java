public PackageElement newPackageElement ( PackageBinding binding ) {
    if ( binding instanceof SplitPackageBinding && binding.enclosingModule != null ) {
        binding = ( ( SplitPackageBinding ) binding ).getIncarnation ( binding.enclosingModule );
    }
    if ( binding == null ) {
        return null;
    }
    return new PackageElementImpl ( _env, binding );
}
