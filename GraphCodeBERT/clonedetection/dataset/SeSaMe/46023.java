public int getIndexOfChild ( Object parent, Object child ) {
    if ( parent == null || child == null ) {
        return -1;
    }
    return ( ( TreeNode ) parent ).getIndex ( ( TreeNode ) child );
}
