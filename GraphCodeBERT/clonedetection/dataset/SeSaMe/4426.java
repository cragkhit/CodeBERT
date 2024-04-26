protected void initializeColumnLabels() {
    if ( getNumObjectiveFunctions() == 2 ) {
        columnLabels.add ( "W" );
    }
    columnLabels.add ( "Z" );
    for ( int i = 0; i < getOriginalNumDecisionVariables(); i++ ) {
        columnLabels.add ( "x" + i );
    }
    if ( !restrictToNonNegative ) {
        columnLabels.add ( NEGATIVE_VAR_COLUMN_LABEL );
    }
    for ( int i = 0; i < getNumSlackVariables(); i++ ) {
        columnLabels.add ( "s" + i );
    }
    for ( int i = 0; i < getNumArtificialVariables(); i++ ) {
        columnLabels.add ( "a" + i );
    }
    columnLabels.add ( "RHS" );
}
