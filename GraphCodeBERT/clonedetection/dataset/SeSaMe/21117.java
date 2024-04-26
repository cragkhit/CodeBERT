static void url ( String urls ) throws Exception {
    Authenticator.setDefault ( new MyAuthenticator () );
    URL url = new URL ( urls );
    InputStream ins = url.openConnection().getInputStream();
    BufferedReader reader = new BufferedReader ( new InputStreamReader ( ins ) );
    String str;
    while ( ( str = reader.readLine() ) != null ) {
        System.out.println ( str );
    }
}
