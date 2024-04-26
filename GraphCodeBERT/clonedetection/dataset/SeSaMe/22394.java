protected void unlockAndThrow ( Exception e ) {
    unlockQueue();
    throw ( new JemmyException ( "Exception during queue locking", e ) );
}
