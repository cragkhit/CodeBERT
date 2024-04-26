public void               setCurrentNode ( Node node ) {
    if ( node == null ) {
        String msg = DOMMessageFormatter.formatMessage ( DOMMessageFormatter.DOM_DOMAIN, "NOT_SUPPORTED_ERR", null );
        throw new DOMException ( DOMException.NOT_SUPPORTED_ERR, msg );
    }
    fCurrentNode = node;
}
