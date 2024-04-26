@Override
public boolean hasNext() {
    if ( next != null ) {
        return true;
    }
    if ( !recordReader.hasNext() ) {
        return false;
    }
    while ( next == null && recordReader.hasNext() ) {
        Record r = recordReader.nextRecord();
        List<Writable> temp = transformProcess.execute ( r.getRecord() );
        if ( temp == null ) {
            continue;
        }
        next = new org.datavec.api.records.impl.Record ( temp, r.getMetaData() );
    }
    return next != null;
}
