public List<T> getMode() {
    long mostPopular = 0; 
    for ( Long l : freqTable.values() ) {
        long frequency = l.longValue();
        if ( frequency > mostPopular ) {
            mostPopular = frequency;
        }
    }
    List<T> modeList = new ArrayList<>();
    for ( Entry<T, Long> ent : freqTable.entrySet() ) {
        long frequency = ent.getValue().longValue();
        if ( frequency == mostPopular ) {
            modeList.add ( ent.getKey() );
        }
    }
    return modeList;
}
