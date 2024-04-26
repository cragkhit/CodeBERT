public boolean isNodeSibling ( Node anotherNode ) {
    if ( parent == null ) {
        return false;
    }
    return ( parent == anotherNode.parent );
}
