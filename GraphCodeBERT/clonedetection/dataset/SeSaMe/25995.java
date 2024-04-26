BitArray getUnalignedBitString() throws IOException {
    if ( pos >= count ) {
        return null;
    }
    int len = available();
    int unusedBits = buf[pos] & 0xff;
    if ( unusedBits > 7 ) {
        throw new IOException ( "Invalid value for unused bits: " + unusedBits );
    }
    byte[] bits = new byte[len - 1];
    int length = ( bits.length == 0 ) ? 0 : bits.length * 8 - unusedBits;
    System.arraycopy ( buf, pos + 1, bits, 0, len - 1 );
    BitArray bitArray = new BitArray ( length, bits );
    pos = count;
    return bitArray;
}
