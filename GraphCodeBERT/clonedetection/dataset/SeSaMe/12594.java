public FingerprintTestResult test ( IPath path, IProgressMonitor monitor ) throws CoreException {
    SubMonitor subMonitor = SubMonitor.convert ( monitor, 100 );
    long currentTime = System.currentTimeMillis();
    IFileStore store = EFS.getLocalFileSystem().getStore ( path );
    IFileInfo fileInfo = store.fetchInfo();
    long lastModified = fileInfo.getLastModified();
    if ( Math.abs ( currentTime - lastModified ) < WORST_FILESYSTEM_TIMESTAMP_ACCURACY_MS ) {
        lastModified = UNKNOWN;
    }
    subMonitor.split ( 5 );
    long fileSize = fileInfo.getLength();
    subMonitor.split ( 5 );
    if ( lastModified != UNKNOWN && lastModified == this.time && fileSize == this.size ) {
        return new FingerprintTestResult ( true, false, this );
    }
    long hashCode;
    try {
        hashCode = fileSize == 0 ? 0 : computeHashCode ( path.toFile(), fileSize, subMonitor.split ( 90 ) );
    } catch ( IOException e ) {
        throw new CoreException ( Package.createStatus ( "An error occurred computing a hash code", e ) ); 
    }
    boolean matches = ( hashCode == this.hash && fileSize == this.size );
    FileFingerprint newFingerprint = new FileFingerprint ( lastModified, fileSize, hashCode );
    return new FingerprintTestResult ( matches, !equals ( newFingerprint ), newFingerprint );
}
