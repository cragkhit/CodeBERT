public boolean getResult() {
    try {
        final LiteralExpr arg = ( LiteralExpr ) argument();
        final String qname = arg.getValue();
        final int index = qname.indexOf ( ':' );
        final String localName = ( index > 0 ) ?
                                 qname.substring ( index + 1 ) : qname;
        return getParser().elementSupported ( arg.getNamespace(),
                                              localName );
    } catch ( ClassCastException e ) {
        return false;
    }
}
