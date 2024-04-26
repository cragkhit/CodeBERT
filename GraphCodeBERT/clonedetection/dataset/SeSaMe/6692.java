public void save ( File... files ) throws IOException {
    getFeatureStats().save ( files[0], files[1] );
    if ( isFitLabel() ) {
        getLabelStats().save ( files[2], files[3] );
    }
}
