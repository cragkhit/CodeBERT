public int getWaitQueueLength ( Condition condition ) {
    if ( condition == null ) {
        throw new NullPointerException();
    }
    if ( ! ( condition instanceof AbstractQueuedSynchronizer.ConditionObject ) ) {
        throw new IllegalArgumentException ( "not owner" );
    }
    return sync.getWaitQueueLength ( ( AbstractQueuedSynchronizer.ConditionObject ) condition );
}
