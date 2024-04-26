public final N adjacentNode ( Object node ) {
    if ( node.equals ( nodeU ) ) {
        return nodeV;
    } else if ( node.equals ( nodeV ) ) {
        return nodeU;
    } else {
        throw new IllegalArgumentException ( "EndpointPair " + this + " does not contain node " + node );
    }
}
