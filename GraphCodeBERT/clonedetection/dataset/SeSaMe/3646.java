public static SparseGradient createVariable ( final int idx, final double value ) {
    return new SparseGradient ( value, Collections.singletonMap ( idx, 1.0 ) );
}
