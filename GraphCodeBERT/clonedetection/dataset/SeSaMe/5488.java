public int readLabel() throws IOException {
    if ( labels == null ) {
        throw new IllegalStateException ( "labels file not initialized." );
    }
    return labels.readLabel();
}
