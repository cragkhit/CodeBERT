public void start() {
    if ( this.runningState == State.STOPPED ) {
        throw new IllegalStateException ( "Stopwatch must be reset before being restarted. " );
    }
    if ( this.runningState != State.UNSTARTED ) {
        throw new IllegalStateException ( "Stopwatch already started. " );
    }
    this.startTime = System.nanoTime();
    this.startTimeMillis = System.currentTimeMillis();
    this.runningState = State.RUNNING;
}
