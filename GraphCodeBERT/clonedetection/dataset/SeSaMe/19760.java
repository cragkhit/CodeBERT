public void setPingTimeout ( long timeout ) {
    if ( connection == null ) {
        throw new TestBug ( "Attempt to set ping timeout for not established connection" );
    }
    connection.setPingTimeout ( timeout );
}
