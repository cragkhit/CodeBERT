protected void checkModifiers() {
    final DetailAST modifiers =
        mainAst.findFirstToken ( TokenTypes.MODIFIERS );
    for ( DetailAST modifier = modifiers.getFirstChild();
            modifier != null;
            modifier = modifier.getNextSibling() ) {
        if ( isOnStartOfLine ( modifier )
                && !getIndent().isAcceptable ( expandedTabsColumnNo ( modifier ) ) ) {
            logError ( modifier, "modifier",
                       expandedTabsColumnNo ( modifier ) );
        }
    }
}
