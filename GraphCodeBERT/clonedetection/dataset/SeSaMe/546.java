public static void main ( final String... args ) {
    SwingUtilities.invokeLater ( () -> {
        final MainFrame mainFrame = new MainFrame();
        if ( args.length > 0 ) {
            final File sourceFile = new File ( args[0] );
            mainFrame.openFile ( sourceFile );
        }
        mainFrame.setTitle ( "Checkstyle GUI" );
        mainFrame.setDefaultCloseOperation ( WindowConstants.EXIT_ON_CLOSE );
        mainFrame.setVisible ( true );
    } );
}
