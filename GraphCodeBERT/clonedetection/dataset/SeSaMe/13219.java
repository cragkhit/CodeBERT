public final boolean safeSubtreeListMatch ( List list1, List list2 ) {
    int size1 = list1.size();
    int size2 = list2.size();
    if ( size1 != size2 ) {
        return false;
    }
    for ( Iterator it1 = list1.iterator(), it2 = list2.iterator(); it1.hasNext(); ) {
        ASTNode n1 = ( ASTNode ) it1.next();
        ASTNode n2 = ( ASTNode ) it2.next();
        if ( !n1.subtreeMatch ( this, n2 ) ) {
            return false;
        }
    }
    return true;
}
