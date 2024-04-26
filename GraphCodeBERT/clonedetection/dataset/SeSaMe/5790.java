@Override
public void purgeConstants() {
    buffersCache = new HashMap<>();
    protector.purgeProtector();
    resetHappened = true;
    logger.info ( "Resetting Constants..." );
    for ( Integer device : constantOffsets.keySet() ) {
        constantOffsets.get ( device ).set ( 0 );
        buffersCache.put ( device, new ConcurrentHashMap<ArrayDescriptor, DataBuffer>() );
    }
}
