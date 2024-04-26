public String getState ( MindMapNode node ) {
    if ( mTargetToId.containsKey ( node ) ) {
        return ( String ) mTargetToId.get ( node );
    }
    return null;
}
