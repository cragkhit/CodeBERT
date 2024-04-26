public void readBytes ( byte[] buf, int off, int len ) throws IOException {
    int startIdx = off;
    int numRead = 0;
    if ( pushedBack ) {
        buf[startIdx] = backBuf;
        pushedBack = false;
        ++startIdx;
        ++numRead;
    }
    while ( numRead < len ) {
        numRead += in.read ( buf, startIdx + numRead, len - numRead );
    }
}
