protected DetailAST getNonListChild() {
    return getMainAst().findFirstToken ( TokenTypes.RPAREN ).getNextSibling();
}
