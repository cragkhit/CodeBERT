public Enumeration<TreePath> getVisiblePathsFrom ( TreePath path ) {
    if ( path == null ) {
        return null;
    }
    FHTreeStateNode         node = getNodeForPath ( path, true, false );
    if ( node != null ) {
        return new VisibleFHTreeStateNodeEnumeration ( node );
    }
    TreePath            parentPath = path.getParentPath();
    node = getNodeForPath ( parentPath, true, false );
    if ( node != null && node.isExpanded() ) {
        return new VisibleFHTreeStateNodeEnumeration ( node,
                treeModel.getIndexOfChild ( parentPath.getLastPathComponent(),
                                            path.getLastPathComponent() ) );
    }
    return null;
}
