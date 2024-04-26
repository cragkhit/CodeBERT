public void copyInto ( byte[] dst, int off, int len ) {
    System.arraycopy ( data.array(), 0, dst, off, len );
}
