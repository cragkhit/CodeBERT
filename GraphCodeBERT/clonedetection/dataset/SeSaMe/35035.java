public TryNode setBody ( final LexicalContext lc, final Block body ) {
    if ( this.body == body ) {
        return this;
    }
    return Node.replaceInLexicalContext ( lc, this, new TryNode ( this,  body, catchBlocks, finallyBody, conversion, inlinedFinallies, exception ) );
}
