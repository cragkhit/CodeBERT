public void setFirstAttribute ( SyntaxTreeNode attribute ) {
    if ( _attributeElements == null ) {
        _attributeElements = new ArrayList<> ( 2 );
    }
    _attributeElements.add ( 0, attribute );
}
