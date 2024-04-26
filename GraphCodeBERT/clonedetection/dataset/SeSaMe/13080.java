public Name getName()  {
    if ( this.name == null ) {
        synchronized ( this ) {
            if ( this.name == null ) {
                preLazyInit();
                this.name = this.ast.newQualifiedName (
                                new SimpleName ( this.ast ), new SimpleName ( this.ast ) );
                postLazyInit ( this.name, NAME_PROPERTY );
            }
        }
    }
    return this.name;
}
