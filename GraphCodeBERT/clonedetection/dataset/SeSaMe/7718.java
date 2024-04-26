public static double ssTotal ( double[] residuals, double[] targetAttribute ) {
    return ssReg ( residuals, targetAttribute ) + ssError ( residuals, targetAttribute );
}
