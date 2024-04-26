void run() throws Exception {
    Set<Example> examples = getExamples();
    Set<String> notYetList = getNotYetList();
    Set<String> declaredKeys = new TreeSet<String>();
    for ( Example e : examples ) {
        Set<String> e_decl = e.getDeclaredKeys();
        Set<String> e_actual = e.getActualKeys();
        for ( String k : e_decl ) {
            if ( !e_actual.contains ( k ) ) {
                error ( "Example " + e + " declares key " + k + " but does not generate it" );
            }
        }
        for ( String k : e_actual ) {
            if ( !e_decl.contains ( k ) ) {
                error ( "Example " + e + " generates key " + k + " but does not declare it" );
            }
        }
        for ( String k : e.getDeclaredKeys() ) {
            if ( notYetList.contains ( k ) ) {
                error ( "Example " + e + " declares key " + k + " which is also on the \"not yet\" list" );
            }
            declaredKeys.add ( k );
        }
    }
    Module jdk_compiler = ModuleLayer.boot().findModule ( "jdk.compiler" ).get();
    ResourceBundle b =
        ResourceBundle.getBundle ( "com.sun.tools.javac.resources.compiler", jdk_compiler );
    Set<String> resourceKeys = new TreeSet<String> ( b.keySet() );
    for ( String dk : declaredKeys ) {
        if ( !resourceKeys.contains ( dk ) ) {
            error ( "Key " + dk + " is declared in tests but is not a valid key in resource bundle" );
        }
    }
    for ( String nk : notYetList ) {
        if ( !resourceKeys.contains ( nk ) ) {
            error ( "Key " + nk + " is declared in not-yet list but is not a valid key in resource bundle" );
        }
    }
    for ( String rk : resourceKeys ) {
        if ( !declaredKeys.contains ( rk ) && !notYetList.contains ( rk ) ) {
            error ( "Key " + rk + " is declared in resource bundle but is not in tests or not-yet list" );
        }
    }
    System.err.println ( examples.size() + " examples checked" );
    System.err.println ( notYetList.size() + " keys on not-yet list" );
    Counts declaredCounts = new Counts ( declaredKeys );
    Counts resourceCounts = new Counts ( resourceKeys );
    List<String> rows = new ArrayList<String> ( Arrays.asList ( Counts.prefixes ) );
    rows.add ( "other" );
    rows.add ( "total" );
    System.err.println();
    System.err.println ( String.format ( "%-14s %15s %15s %4s",
                                         "prefix", "#keys in tests", "#keys in javac", "%" ) );
    for ( String p : rows ) {
        int d = declaredCounts.get ( p );
        int r = resourceCounts.get ( p );
        System.err.print ( String.format ( "%-14s %15d %15d", p, d, r ) );
        if ( r != 0 ) {
            System.err.print ( String.format ( " %3d%%", ( d * 100 ) / r ) );
        }
        System.err.println();
    }
    if ( errors > 0 ) {
        throw new Exception ( errors + " errors occurred." );
    }
}
