public void skipRecord() throws IOException {
    if ( debug ) {
        System.err.println ( "SkipRecord: recIdx = " + currRecIdx
                             + " blkIdx = " + currBlkIdx );
    }
    if ( inStream == null ) {
        throw new IOException ( "reading (via skip) from an output buffer" );
    }
    if ( currRecIdx >= recsPerBlock ) {
        if ( !readBlock() ) {
            return;    
        }
    }
    currRecIdx++;
}
