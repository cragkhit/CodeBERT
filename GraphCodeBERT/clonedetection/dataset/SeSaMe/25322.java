boolean run ( String... args ) throws Exception {
    boolean findDeadKeys = false;
    boolean findMissingKeys = false;
    if ( args.length == 0 ) {
        if ( is_jtreg() ) {
            findDeadKeys = true;
            findMissingKeys = true;
        } else {
            System.err.println ( "Usage: java CheckResourceKeys <options>" );
            System.err.println ( "where options include" );
            System.err.println ( "  -finddeadkeys      find keys in resource bundles which are no longer required" );
            System.err.println ( "  -findmissingkeys   find keys in resource bundles that are required but missing" );
            return true;
        }
    } else {
        for ( String arg : args ) {
            if ( arg.equalsIgnoreCase ( "-finddeadkeys" ) ) {
                findDeadKeys = true;
            } else if ( arg.equalsIgnoreCase ( "-findmissingkeys" ) ) {
                findMissingKeys = true;
            } else {
                error ( "bad option: " + arg );
            }
        }
    }
    if ( errors > 0 ) {
        return false;
    }
    Set<String> codeKeys = getCodeKeys();
    Set<String> resourceKeys = getResourceKeys();
    System.err.println ( "found " + codeKeys.size() + " keys in code" );
    System.err.println ( "found " + resourceKeys.size() + " keys in resource bundles" );
    if ( findDeadKeys ) {
        findDeadKeys ( codeKeys, resourceKeys );
    }
    if ( findMissingKeys ) {
        findMissingKeys ( codeKeys, resourceKeys );
    }
    return ( errors == 0 );
}
