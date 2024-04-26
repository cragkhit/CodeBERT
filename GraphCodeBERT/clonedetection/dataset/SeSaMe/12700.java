public synchronized void removeIndex ( IPath containerPath ) {
    if ( VERBOSE || DEBUG ) {
        Util.verbose ( "removing index " + containerPath );    
    }
    this.indexer.makeWorkspacePathDirty ( containerPath );
    IndexLocation indexLocation = computeIndexLocation ( containerPath );
    Index index = getIndex ( indexLocation );
    File indexFile = null;
    if ( index != null ) {
        index.monitor = null;
        indexFile = index.getIndexFile();
    }
    if ( indexFile == null ) {
        indexFile = indexLocation.getIndexFile();    
    }
    if ( this.indexStates.get ( indexLocation ) == REUSE_STATE ) {
        indexLocation.close();
        this.indexLocations.put ( containerPath, null );
    } else if ( indexFile != null && indexFile.exists() ) {
        if ( DEBUG ) {
            Util.verbose ( "removing index file " + indexFile );    
        }
        indexFile.delete();
    }
    this.indexes.removeKey ( indexLocation );
    if ( IS_MANAGING_PRODUCT_INDEXES_PROPERTY ) {
        this.indexLocations.removeKey ( containerPath );
    }
    updateIndexState ( indexLocation, null );
}
