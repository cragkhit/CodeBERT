protected double[] fct ( double[] f )
throws MathIllegalArgumentException {
    final double[] transformed = new double[f.length];
    final int n = f.length - 1;
    if ( !ArithmeticUtils.isPowerOfTwo ( n ) ) {
        throw new MathIllegalArgumentException (
            LocalizedFormats.NOT_POWER_OF_TWO_PLUS_ONE,
            Integer.valueOf ( f.length ) );
    }
    if ( n == 1 ) {     
        transformed[0] = 0.5 * ( f[0] + f[1] );
        transformed[1] = 0.5 * ( f[0] - f[1] );
        return transformed;
    }
    final double[] x = new double[n];
    x[0] = 0.5 * ( f[0] + f[n] );
    x[n >> 1] = f[n >> 1];
    double t1 = 0.5 * ( f[0] - f[n] );
    for ( int i = 1; i < ( n >> 1 ); i++ ) {
        final double a = 0.5 * ( f[i] + f[n - i] );
        final double b = FastMath.sin ( i * FastMath.PI / n ) * ( f[i] - f[n - i] );
        final double c = FastMath.cos ( i * FastMath.PI / n ) * ( f[i] - f[n - i] );
        x[i] = a - b;
        x[n - i] = a + b;
        t1 += c;
    }
    FastFourierTransformer transformer;
    transformer = new FastFourierTransformer ( DftNormalization.STANDARD );
    Complex[] y = transformer.transform ( x, TransformType.FORWARD );
    transformed[0] = y[0].getReal();
    transformed[1] = t1;
    for ( int i = 1; i < ( n >> 1 ); i++ ) {
        transformed[2 * i]     = y[i].getReal();
        transformed[2 * i + 1] = transformed[2 * i - 1] - y[i].getImaginary();
    }
    transformed[n] = y[n >> 1].getReal();
    return transformed;
}
