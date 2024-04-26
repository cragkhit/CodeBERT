public double getResult() throws NumberIsTooSmallException {
    if ( n < 2 ) {
        throw new NumberIsTooSmallException ( LocalizedFormats.INSUFFICIENT_DIMENSION,
                                              n, 2, true );
    }
    if ( biasCorrected ) {
        return covarianceNumerator / ( n - 1d );
    } else {
        return covarianceNumerator / n;
    }
}
