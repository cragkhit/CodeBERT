public static Text selectDs11NodeText ( Node sibling, String nodeName, int number ) {
    Node n = selectDs11Node ( sibling, nodeName, number );
    if ( n == null ) {
        return null;
    }
    n = n.getFirstChild();
    while ( n != null && n.getNodeType() != Node.TEXT_NODE ) {
        n = n.getNextSibling();
    }
    return ( Text ) n;
}
