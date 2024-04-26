public static synchronized void loadLibrary ( File jar ) throws NoAvailableBackendException {
    try {
        java.net.URLClassLoader loader = ( java.net.URLClassLoader ) ClassLoader.getSystemClassLoader();
        java.net.URL url = jar.toURI().toURL();
        for ( java.net.URL it : java.util.Arrays.asList ( loader.getURLs() ) ) {
            if ( it.equals ( url ) ) {
                return;
            }
        }
        java.lang.reflect.Method method =
            java.net.URLClassLoader.class.getDeclaredMethod ( "addURL", new Class[] {java.net.URL.class} );
        method.setAccessible ( true );  
        method.invoke ( loader, new Object[] {url} );
    } catch ( final java.lang.NoSuchMethodException | java.lang.IllegalAccessException
                  | java.net.MalformedURLException | java.lang.reflect.InvocationTargetException e ) {
        throw new NoAvailableBackendException ( e );
    }
}
