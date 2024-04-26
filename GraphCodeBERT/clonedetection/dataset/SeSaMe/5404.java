public static TimingStatistics timeNDArrayCreation ( RecordReader reader,
        InputStream inputStream,
        INDArrayCreationFunction function ) throws Exception {
    reader.initialize ( new InputStreamInputSplit ( inputStream ) );
    long longNanos = System.nanoTime();
    List<Writable> next = reader.next();
    long endNanos = System.nanoTime();
    long etlDiff = endNanos - longNanos;
    long startArrCreation = System.nanoTime();
    INDArray arr = function.createFromRecord ( next );
    long endArrCreation = System.nanoTime();
    long endCreationDiff = endArrCreation - startArrCreation;
    Map<Integer, Map<MemcpyDirection, Long>> currentBandwidth = PerformanceTracker.getInstance().getCurrentBandwidth();
    val bw = currentBandwidth.get ( 0 ).get ( MemcpyDirection.HOST_TO_DEVICE );
    val deviceToHost = currentBandwidth.get ( 0 ).get ( MemcpyDirection.HOST_TO_DEVICE );
    return TimingStatistics.builder()
           .diskReadingTimeNanos ( etlDiff )
           .bandwidthNanosHostToDevice ( bw )
           .bandwidthDeviceToHost ( deviceToHost )
           .ndarrayCreationTimeNanos ( endCreationDiff )
           .build();
}
