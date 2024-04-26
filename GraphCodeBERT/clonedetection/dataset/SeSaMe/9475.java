public static synchronized UIServer getInstance() {
    if ( uiServer == null ) {
        PlayUIServer playUIServer = new PlayUIServer();
        playUIServer.runMain ( new String[] {"--uiPort", String.valueOf ( PlayUIServer.DEFAULT_UI_PORT ) } );
        uiServer = playUIServer;
    }
    return uiServer;
}
