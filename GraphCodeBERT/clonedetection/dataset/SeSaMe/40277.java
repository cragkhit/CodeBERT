public int getMinorVersion() {
    byte[] theHeader;
    theHeader = getData ( icSigHead );  
    return ( int ) theHeader[9];
}
