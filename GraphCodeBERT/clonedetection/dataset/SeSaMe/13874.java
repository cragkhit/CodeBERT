protected void closeBuffer() {
    if ( !hasBuffer() ) {
        return;    
    }
    IBuffer buffer = getBufferManager().getBuffer ( this );
    if ( buffer != null ) {
        buffer.close();
        buffer.removeBufferChangedListener ( this );
    }
}
