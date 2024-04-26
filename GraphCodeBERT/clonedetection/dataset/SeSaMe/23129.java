public void selectPath ( final TreePath path ) {
    if ( path != null ) {
        output.printLine ( "Selecting \"" + path.toString() + "\" path" );
        output.printGolden ( "Selecting path" );
        scrollToPath ( path );
        getQueueTool().invokeSmoothly ( new QueueTool.QueueAction<Void> ( "Path selecting" ) {
            @Override
            public Void launch() {
                driver.selectItem ( JTreeOperator.this, getRowForPath ( path ) );
                return null;
            }
        } );
        if ( getVerification() ) {
            waitSelected ( path );
        }
    } else {
        throw ( new NoSuchPathException() );
    }
}
