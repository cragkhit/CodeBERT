public static SimpleBounds unbounded ( int dim ) {
    final double[] lB = new double[dim];
    Arrays.fill ( lB, Double.NEGATIVE_INFINITY );
    final double[] uB = new double[dim];
    Arrays.fill ( uB, Double.POSITIVE_INFINITY );
    return new SimpleBounds ( lB, uB );
}
