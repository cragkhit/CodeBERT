public void removeAllChildren() {
    for ( int i = 0; i < children.size(); i++ ) {
        Node node = ( Node ) children.items[i];
        node.setParent ( null );
    }
    children.clear();
}
