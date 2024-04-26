@Deprecated
public Builder debugLongerIterations ( long timeMs ) {
    if ( timeMs < 0 ) {
        timeMs = 0L;
    }
    this.debugLongerIterations = timeMs;
    return this;
}
