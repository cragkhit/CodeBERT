protected void checkTopLevelToken() {
    final DetailAST topLevel = getTopLevelAst();
    if ( topLevel != null
            && !getIndent().isAcceptable ( expandedTabsColumnNo ( topLevel ) )
            && isOnStartOfLine ( topLevel ) ) {
        logError ( topLevel, "", expandedTabsColumnNo ( topLevel ) );
    }
}
