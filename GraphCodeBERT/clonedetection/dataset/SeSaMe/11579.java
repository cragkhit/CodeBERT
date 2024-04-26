protected void runTest() throws Throwable {
    assertNotNull ( fName );
    Method runMethod = null;
    try {
        runMethod = getClass().getMethod ( fName, null );
    } catch ( NoSuchMethodException e ) {
        fail ( "Method \"" + fName + "\" not found" );
    }
    if ( !Modifier.isPublic ( runMethod.getModifiers() ) ) {
        fail ( "Method \"" + fName + "\" should be public" );
    }
    try {
        runMethod.invoke ( this, new Class[0] );
    } catch ( InvocationTargetException e ) {
        e.fillInStackTrace();
        throw e.getTargetException();
    } catch ( IllegalAccessException e ) {
        e.fillInStackTrace();
        throw e;
    }
}
