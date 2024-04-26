public void resetBuffer() {
    super.resetBuffer();
    while ( length() < PacketHeaderSize ) {
        addByte ( ( byte ) 0 );
    }
    setLength();
    resetPosition();
}
