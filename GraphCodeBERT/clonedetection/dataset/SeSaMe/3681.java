public PolynomialFunction negate() {
    double[] newCoefficients = new double[coefficients.length];
    for ( int i = 0; i < coefficients.length; ++i ) {
        newCoefficients[i] = -coefficients[i];
    }
    return new PolynomialFunction ( newCoefficients );
}
