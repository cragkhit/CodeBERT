public boolean hasChildNodes() {
    if ( needsSyncChildren() ) {
        synchronizeChildren();
    }
    return firstChild != null;
}
