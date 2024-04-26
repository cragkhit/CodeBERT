protected int getNodeNumber() {
    int nodeNumber;
    CoreDocumentImpl cd = ( CoreDocumentImpl ) ( this.getOwnerDocument() );
    nodeNumber = cd.getNodeNumber ( this );
    return nodeNumber;
}
