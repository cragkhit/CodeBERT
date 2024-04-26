public void addFieldInfos() {
    SourceTypeBinding currentBinding = this.referenceBinding;
    FieldBinding[] syntheticFields = currentBinding.syntheticFields();
    int fieldCount = 	currentBinding.fieldCount() + ( syntheticFields == null ? 0 : syntheticFields.length );
    if ( fieldCount > 0xFFFF ) {
        this.referenceBinding.scope.problemReporter().tooManyFields ( this.referenceBinding.scope.referenceType() );
    }
    this.contents[this.contentsOffset++] = ( byte ) ( fieldCount >> 8 );
    this.contents[this.contentsOffset++] = ( byte ) fieldCount;
    FieldDeclaration[] fieldDecls = currentBinding.scope.referenceContext.fields;
    for ( int i = 0, max = fieldDecls == null ? 0 : fieldDecls.length; i < max; i++ ) {
        FieldDeclaration fieldDecl = fieldDecls[i];
        if ( fieldDecl.binding != null ) {
            addFieldInfo ( fieldDecl.binding );
        }
    }
    if ( syntheticFields != null ) {
        for ( int i = 0, max = syntheticFields.length; i < max; i++ ) {
            addFieldInfo ( syntheticFields[i] );
        }
    }
}
