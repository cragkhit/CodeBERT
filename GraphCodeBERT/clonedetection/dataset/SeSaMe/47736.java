public final int getVersionNumber() {
    if ( destroyed ) {
        throw new IllegalStateException ( "This key is no longer valid" );
    }
    return versionNum;
}
