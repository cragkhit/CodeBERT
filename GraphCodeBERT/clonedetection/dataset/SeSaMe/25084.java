Set<Example> getExamples() {
    Set<Example> results = new TreeSet<Example>();
    File testSrc = new File ( System.getProperty ( "test.src" ) );
    File examples = new File ( testSrc, "examples" );
    for ( File f : examples.listFiles() ) {
        if ( isValidExample ( f ) ) {
            results.add ( new Example ( f ) );
        }
    }
    return results;
}
