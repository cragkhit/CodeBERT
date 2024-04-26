protected String createPath() {
    Path baseDir;
    try {
        baseDir = DebugOptions.getDumpDirectory ( options );
    } catch ( IOException e ) {
        baseDir = Paths.get ( "." );
    }
    return baseDir.resolve ( "graal_diagnostics_" + GraalServices.getExecutionID() ).toAbsolutePath().toString();
}
