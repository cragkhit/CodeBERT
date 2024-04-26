public final void finalize() {
    synchronized ( this.getClass() ) {
        FinalizerYes.noOfFinalized++;
    }
}
