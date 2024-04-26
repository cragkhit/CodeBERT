public void unsplit() {
    if ( this.splitState != SplitState.SPLIT ) {
        throw new IllegalStateException ( "Stopwatch has not been split. " );
    }
    this.splitState = SplitState.UNSPLIT;
}
