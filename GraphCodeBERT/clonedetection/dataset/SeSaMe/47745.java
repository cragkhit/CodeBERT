public KerberosPrincipal getSender() {
    if ( destroyed ) {
        throw new IllegalStateException ( "This object is no longer valid" );
    }
    return sender;
}
