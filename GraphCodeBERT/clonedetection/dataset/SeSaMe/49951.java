public void setNodeValue ( String x )
throws DOMException {
    if ( ownerDocument.errorChecking && isReadOnly() ) {
        String msg = DOMMessageFormatter.formatMessage ( DOMMessageFormatter.DOM_DOMAIN, "NO_MODIFICATION_ALLOWED_ERR", null );
        throw new DOMException ( DOMException.NO_MODIFICATION_ALLOWED_ERR, msg );
    }
}
