public byte[] toUtf() {
    byte[] bs = new byte[getByteLength()];
    getBytes ( bs, 0 );
    return bs;
}
