public void saveIndexes() {
    ArrayList toSave = new ArrayList();
    synchronized ( this ) {
        Object[] valueTable = this.indexes.valueTable;
        for ( int i = 0, l = valueTable.length; i < l; i++ ) {
            Index index = ( Index ) valueTable[i];
            if ( index != null ) {
                toSave.add ( index );
            }
        }
    }
    boolean allSaved = true;
    for ( int i = 0, length = toSave.size(); i < length; i++ ) {
        Index index = ( Index ) toSave.get ( i );
        ReadWriteMonitor monitor = index.monitor;
        if ( monitor == null ) {
            continue;    
        }
        try {
            monitor.enterRead();
            if ( index.hasChanged() ) {
                if ( monitor.exitReadEnterWrite() ) {
                    try {
                        saveIndex ( index );
                    } catch ( IOException e ) {
                        if ( VERBOSE ) {
                            Util.verbose ( "-> got the following exception while saving:", System.err ); 
                            e.printStackTrace();
                        }
                        allSaved = false;
                    } finally {
                        monitor.exitWriteEnterRead();
                    }
                } else {
                    allSaved = false;
                }
            }
        } finally {
            monitor.exitRead();
        }
    }
    if ( this.participantsContainers != null && this.participantUpdated ) {
        writeParticipantsIndexNamesFile();
        this.participantUpdated = false;
    }
    this.needToSave = !allSaved;
}
