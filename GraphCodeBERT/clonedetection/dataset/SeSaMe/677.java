public static boolean areOnSameLine ( DetailAST ast1, DetailAST ast2 ) {
    return ast1.getLineNo() == ast2.getLineNo();
}
