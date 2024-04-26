public static DistributionStats load ( @NonNull File meanFile, @NonNull File stdFile ) throws IOException {
    return new DistributionStats ( Nd4j.readBinary ( meanFile ), Nd4j.readBinary ( stdFile ) );
}
