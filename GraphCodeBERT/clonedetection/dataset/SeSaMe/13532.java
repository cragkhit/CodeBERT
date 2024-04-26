public Block getBody() {
    if ( this.body == null ) {
        synchronized ( this ) {
            if ( this.body == null ) {
                preLazyInit();
                this.body = new Block ( this.ast );
                postLazyInit ( this.body, BODY_PROPERTY );
            }
        }
    }
    return this.body;
}
