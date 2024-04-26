public double[] y() {
    final double[] v = new double[points.size()];
    for ( int i = 0; i < points.size(); i++ ) {
        final double[] p = points.get ( i );
        v[i] = p[1]; 
    }
    return v;
}
