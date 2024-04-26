@Override
public void reset() {
    if ( !iter.resetSupported() ) {
        throw new IllegalStateException (
            "Cannot reset MultipleEpochsIterator with base iter that does not support reset" );
    }
    epochs = 0;
    lastBatch = batch;
    batch = 0;
    iterationsCounter.set ( 0 );
    iter.reset();
}
