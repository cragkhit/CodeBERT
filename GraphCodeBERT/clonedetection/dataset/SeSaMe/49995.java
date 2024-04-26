public String getNodeName() {
    if ( needsSyncData() ) {
        synchronizeData();
    }
    return name;
}
