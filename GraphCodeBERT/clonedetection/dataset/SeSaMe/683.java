protected static int getFirstLine ( int startLine, DetailAST tree ) {
    int realStart = startLine;
    final int currLine = tree.getLineNo();
    if ( currLine < realStart ) {
        realStart = currLine;
    }
    for ( DetailAST node = tree.getFirstChild();
            node != null;
            node = node.getNextSibling() ) {
        realStart = getFirstLine ( realStart, node );
    }
    return realStart;
}
