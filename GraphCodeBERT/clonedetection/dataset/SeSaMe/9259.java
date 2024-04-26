public CAS process ( String text ) {
    CAS cas = retrieve();
    if ( cas == null ) {
        return null;
    }
    cas.setDocumentText ( text );
    try {
        analysisEngine.process ( cas );
    } catch ( AnalysisEngineProcessException e ) {
        log.warn ( "Unable to process text " + text, e );
    }
    return cas;
}
