public void setSpecified ( boolean arg ) {
    if ( needsSyncData() ) {
        synchronizeData();
    }
    isSpecified ( arg );
} 
