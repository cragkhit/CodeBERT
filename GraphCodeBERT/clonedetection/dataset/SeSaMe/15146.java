public Node getRoot() {
    Node node = this;
    while ( !node.isRoot() ) {
        node = node.getParent();
    }
    return node;
}
