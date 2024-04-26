public void treeNodesInserted ( TreeModelEvent e ) {
    if ( e != null ) {
        int                 changedIndexs[];
        FHTreeStateNode     changedParent = getNodeForPath
                                            ( SwingUtilities2.getTreePath ( e, getModel() ), false, false );
        int                 maxCounter;
        changedIndexs = e.getChildIndices();
        if ( changedParent != null && changedIndexs != null &&
                ( maxCounter = changedIndexs.length ) > 0 ) {
            boolean          isVisible =
                ( changedParent.isVisible() &&
                  changedParent.isExpanded() );
            for ( int counter = 0; counter < maxCounter; counter++ ) {
                changedParent.childInsertedAtModelIndex
                ( changedIndexs[counter], isVisible );
            }
            if ( isVisible && treeSelectionModel != null ) {
                treeSelectionModel.resetRowSelection();
            }
            if ( changedParent.isVisible() ) {
                this.visibleNodesChanged();
            }
        }
    }
}
