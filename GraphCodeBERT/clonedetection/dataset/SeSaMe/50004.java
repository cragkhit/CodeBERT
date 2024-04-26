public NamedNodeMap getElements() {
    if ( needsSyncChildren() ) {
        synchronizeChildren();
    }
    return elements;
}
