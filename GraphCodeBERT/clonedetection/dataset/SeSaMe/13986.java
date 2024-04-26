public Enumeration<IBuffer> getOpenBuffers() {
    Enumeration<IBuffer> result;
    synchronized ( this.openBuffers ) {
        this.openBuffers.shrink();
        result = this.openBuffers.elements();
    }
    this.openBuffers.closeBuffers();
    return result;
}
