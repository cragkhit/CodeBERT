protected void accumulateLabel ( String path ) {
    String name = getLabel ( path );
    if ( !labels.contains ( name ) ) {
        labels.add ( name );
    }
}
