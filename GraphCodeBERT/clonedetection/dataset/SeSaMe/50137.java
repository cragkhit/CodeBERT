public Node replaceChild ( Node newChild, Node oldChild )
throws DOMException {
    if ( newChild.getOwnerDocument() == null &&
            newChild instanceof DocumentTypeImpl ) {
        ( ( DocumentTypeImpl ) newChild ).ownerDocument = this;
    }
    if ( errorChecking && ( ( docType != null &&
                              oldChild.getNodeType() != Node.DOCUMENT_TYPE_NODE &&
                              newChild.getNodeType() == Node.DOCUMENT_TYPE_NODE )
                            || ( docElement != null &&
                                 oldChild.getNodeType() != Node.ELEMENT_NODE &&
                                 newChild.getNodeType() == Node.ELEMENT_NODE ) ) ) {
        throw new DOMException (
            DOMException.HIERARCHY_REQUEST_ERR,
            DOMMessageFormatter.formatMessage ( DOMMessageFormatter.DOM_DOMAIN, "HIERARCHY_REQUEST_ERR", null ) );
    }
    super.replaceChild ( newChild, oldChild );
    int type = oldChild.getNodeType();
    if ( type == Node.ELEMENT_NODE ) {
        docElement = ( ElementImpl ) newChild;
    } else if ( type == Node.DOCUMENT_TYPE_NODE ) {
        docType = ( DocumentTypeImpl ) newChild;
    }
    return oldChild;
}   
