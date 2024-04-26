public void setRightChildIndent ( int newAmount ) {
    rightChildIndent = newAmount;
    totalChildIndent = leftChildIndent + rightChildIndent;
    if ( treeState != null ) {
        treeState.invalidateSizes();
    }
    updateSize();
}
