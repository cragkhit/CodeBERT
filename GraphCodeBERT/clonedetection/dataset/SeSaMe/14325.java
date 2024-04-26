public void checkCancel() {
    if ( this.monitor != null && this.monitor.isCanceled() ) {
        throw new OperationCanceledException();
    }
}
