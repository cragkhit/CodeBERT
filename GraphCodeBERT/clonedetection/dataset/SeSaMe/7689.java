public BigInteger floor() {
    if ( b.compareTo ( BigInteger.ONE ) == 0 ) {
        return a;
    } else if ( a.compareTo ( BigInteger.ZERO ) > 0 ) {
        return a.divide ( b );
    } else {
        return a.divide ( b ).subtract ( BigInteger.ONE );
    }
}  
