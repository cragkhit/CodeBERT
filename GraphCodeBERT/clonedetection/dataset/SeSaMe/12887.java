public SimpleName getName() {
    if ( this.methodName == null ) {
        synchronized ( this ) {
            if ( this.methodName == null ) {
                preLazyInit();
                this.methodName = new SimpleName ( this.ast );
                postLazyInit ( this.methodName, NAME_PROPERTY );
            }
        }
    }
    return this.methodName;
}
