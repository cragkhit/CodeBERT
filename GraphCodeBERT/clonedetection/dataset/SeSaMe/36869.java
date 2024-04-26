@Override
public synchronized void removeAll() {
    DefaultTreeModel model = ( DefaultTreeModel ) getModel();
    DefaultMutableTreeNode root = ( DefaultMutableTreeNode ) model.getRoot();
    root.removeAllChildren();
    model.nodeStructureChanged ( root );
    nodes.clear();
}
