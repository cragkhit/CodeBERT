public static Fraction getReducedFraction ( int numerator, int denominator ) {
    if ( denominator == 0 ) {
        throw new ArithmeticException ( "The denominator must not be zero" );
    }
    if ( numerator == 0 ) {
        return ZERO; 
    }
    if ( denominator == Integer.MIN_VALUE && ( numerator & 1 ) == 0 ) {
        numerator /= 2;
        denominator /= 2;
    }
    if ( denominator < 0 ) {
        if ( numerator == Integer.MIN_VALUE || denominator == Integer.MIN_VALUE ) {
            throw new ArithmeticException ( "overflow: can't negate" );
        }
        numerator = -numerator;
        denominator = -denominator;
    }
    final int gcd = greatestCommonDivisor ( numerator, denominator );
    numerator /= gcd;
    denominator /= gcd;
    return new Fraction ( numerator, denominator );
}
