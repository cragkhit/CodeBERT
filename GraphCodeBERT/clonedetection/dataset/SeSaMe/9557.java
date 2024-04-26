public void attachMDS ( Iterator<MultiDataSet> iterator ) {
    log.debug ( "Attaching thread..." );
    if ( iteratorDataSetCount.get() == null ) {
        iteratorDataSetCount.set ( new AtomicInteger ( 0 ) );
    }
    AtomicInteger count = iteratorDataSetCount.get();
    count.set ( 0 );
    VirtualIterator<MultiDataSet> wrapped = new VirtualIterator<> ( new CountingIterator<> ( iterator, count ) );
    BlockingObserver obs = new BlockingObserver ( exceptionEncountered );
    wrapped.addObserver ( obs );
    iteratorsMDS.add ( wrapped );
    observer.set ( obs );
}
