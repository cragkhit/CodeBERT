public void parseContents ( Parser parser ) {
    super.parseContents ( parser );
    SyntaxTreeNode parent = getParent();
    if ( parent instanceof Stylesheet ) {
        _isLocal = false;
        Variable var = parser.getSymbolTable().lookupVariable ( _name );
        if ( var != null ) {
            final int us = this.getImportPrecedence();
            final int them = var.getImportPrecedence();
            if ( us == them ) {
                final String name = _name.toString();
                reportError ( this, parser, ErrorMsg.VARIABLE_REDEF_ERR, name );
            }
            else if ( them > us ) {
                _ignore = true;
                copyReferences ( var );
                return;
            } else {
                var.copyReferences ( this );
                var.disable();
            }
        }
        ( ( Stylesheet ) parent ).addVariable ( this );
        parser.getSymbolTable().addVariable ( this );
    } else {
        _isLocal = true;
    }
}
