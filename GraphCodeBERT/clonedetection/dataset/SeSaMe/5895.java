protected synchronized long seekUnusedZero ( Long bucketId, Aggressiveness aggressiveness ) {
    AtomicLong freeSpace = new AtomicLong ( 0 );
    int totalElements = ( int ) memoryHandler.getAllocatedHostObjects ( bucketId );
    float shortAverage = zeroShort.getAverage();
    float longAverage = zeroLong.getAverage();
    float shortThreshold = shortAverage / ( Aggressiveness.values().length - aggressiveness.ordinal() );
    float longThreshold = longAverage / ( Aggressiveness.values().length - aggressiveness.ordinal() );
    AtomicInteger elementsDropped = new AtomicInteger ( 0 );
    AtomicInteger elementsSurvived = new AtomicInteger ( 0 );
    for ( Long object : memoryHandler.getHostTrackingPoints ( bucketId ) ) {
        AllocationPoint point = getAllocationPoint ( object );
        if ( point == null ) {
            continue;
        }
        if ( point.getAllocationStatus() == AllocationStatus.HOST ) {
            if ( point.getBuffer() == null ) {
                purgeZeroObject ( bucketId, object, point, false );
                freeSpace.addAndGet ( AllocationUtils.getRequiredMemory ( point.getShape() ) );
                elementsDropped.incrementAndGet();
                continue;
            } else {
                elementsSurvived.incrementAndGet();
            }
        } else {
        }
    }
    log.debug ( "Zero {} elements checked: [{}], deleted: {}, survived: {}", bucketId, totalElements,
                elementsDropped.get(), elementsSurvived.get() );
    return freeSpace.get();
}
