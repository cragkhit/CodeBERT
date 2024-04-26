@Override
protected void checkModCount() {
    if ( !valid ) {
        throw new ConcurrentModificationException ( "Cursor closed" );
    }
}
