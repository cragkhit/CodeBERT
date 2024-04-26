public Node getNextSibling() {
    return ( parent != null ) ? parent.getChildAfter ( this ) : null;
}
