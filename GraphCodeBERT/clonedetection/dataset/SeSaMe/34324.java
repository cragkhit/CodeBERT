public void sync() throws BackingStoreException {
    if ( isRemoved() ) {
        throw new IllegalStateException ( "Node has been removed" );
    }
    flush();
}
