public MultivariateMatrixFunction getModelFunctionJacobian() {
    return new MultivariateMatrixFunction() {
        @Override
        public double[][] value ( double[] p ) {
            final int len = points.length;
            final double[][] jacobian = new double[len][];
            for ( int i = 0; i < len; i++ ) {
                jacobian[i] = f.gradient ( points[i], p );
            }
            return jacobian;
        }
    };
}
