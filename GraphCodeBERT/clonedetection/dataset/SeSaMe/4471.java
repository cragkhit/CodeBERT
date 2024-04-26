public static BigFraction getReducedFraction ( final int numerator,
        final int denominator ) {
    if ( numerator == 0 ) {
        return ZERO; 
    }
    return new BigFraction ( numerator, denominator );
}
