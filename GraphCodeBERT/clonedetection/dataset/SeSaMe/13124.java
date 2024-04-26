public Expression getExpression() {
    if ( this.conditionExpression == null ) {
        synchronized ( this ) {
            if ( this.conditionExpression == null ) {
                preLazyInit();
                this.conditionExpression = new SimpleName ( this.ast );
                postLazyInit ( this.conditionExpression, EXPRESSION_PROPERTY );
            }
        }
    }
    return this.conditionExpression;
}
