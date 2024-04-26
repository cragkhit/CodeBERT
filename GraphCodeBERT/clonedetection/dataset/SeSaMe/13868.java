@Override
protected void executeOperation() throws JavaModelException {
    try {
        beginTask ( getMainTaskName(), getMainAmountOfWork() );
        JavaElementDelta delta = newJavaElementDelta();
        ICompilationUnit unit = getCompilationUnit();
        generateNewCompilationUnitAST ( unit );
        if ( this.creationOccurred ) {
            unit.save ( null, false );
            boolean isWorkingCopy = unit.isWorkingCopy();
            if ( !isWorkingCopy ) {
                setAttribute ( HAS_MODIFIED_RESOURCE_ATTR, TRUE );
            }
            worked ( 1 );
            this.resultElements = generateResultHandles();
            if ( !isWorkingCopy 
                    && !Util.isExcluded ( unit )
                    && unit.getParent().exists() ) {
                for ( int i = 0; i < this.resultElements.length; i++ ) {
                    delta.added ( this.resultElements[i] );
                }
                addDelta ( delta );
            } 
        }
    } finally {
        done();
    }
}
