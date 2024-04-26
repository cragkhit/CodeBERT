public int getLevel() {
    int lvl = 0;
    if ( this.isRoot() ) {
        return lvl;
    }
    Node node = getParent();
    lvl++;
    while ( !node.isRoot() ) {
        node = node.getParent();
        lvl++;
    }
    return lvl;
}
