public Node getPreviousSibling() {
    if ( parent == null ) {
        return null;
    }
    return parent.getChildBefore ( this );
}
