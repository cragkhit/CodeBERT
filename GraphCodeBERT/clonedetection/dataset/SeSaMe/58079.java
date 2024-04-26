public int startPos ( JCTree tree ) {
    if ( tree == null ) {
        return Position.NOPOS;
    }
    return TreeInfo.getStartPos ( tree );
}
