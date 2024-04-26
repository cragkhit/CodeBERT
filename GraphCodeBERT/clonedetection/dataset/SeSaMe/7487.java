public static List<VersionInfo> getVersionInfos() {
    boolean dl4jFound = false;
    boolean datavecFound = false;
    List<VersionInfo> repState = new ArrayList<>();
    for ( URI s : listGitPropertiesFiles() ) {
        VersionInfo grs;
        try {
            grs = new VersionInfo ( s );
        } catch ( Exception e ) {
            log.debug ( "Error reading property files for {}", s );
            continue;
        }
        repState.add ( grs );
        if ( !dl4jFound && DL4J_GROUPID.equalsIgnoreCase ( grs.getGroupId() ) && DL4J_ARTIFACT.equalsIgnoreCase ( grs.getArtifactId() ) ) {
            dl4jFound = true;
        }
        if ( !datavecFound && DATAVEC_GROUPID.equalsIgnoreCase ( grs.getGroupId() ) && DATAVEC_ARTIFACT.equalsIgnoreCase ( grs.getArtifactId() ) ) {
            datavecFound = true;
        }
    }
    if ( classExists ( ND4J_JBLAS_CLASS ) ) {
        log.error ( "Found incompatible/obsolete backend and version (nd4j-jblas) on classpath. ND4J is unlikely to"
                    + " function correctly with nd4j-jblas on the classpath." );
    }
    if ( classExists ( CANOVA_CLASS ) ) {
        log.error ( "Found incompatible/obsolete library Canova on classpath. ND4J is unlikely to"
                    + " function correctly with this library on the classpath." );
    }
    return repState;
}
