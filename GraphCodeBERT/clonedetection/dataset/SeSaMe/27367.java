public Loader loaderFor ( String name ) {
    Loader loader = loaders.get ( name );
    assert loader != null;
    return loader;
}
