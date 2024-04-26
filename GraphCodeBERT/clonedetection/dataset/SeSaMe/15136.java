public void add ( Node newChild ) {
    remove ( newChild );
    newChild.setParent ( this );
    children.add ( newChild );
}
