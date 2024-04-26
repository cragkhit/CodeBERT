public static double sin ( double x ) {
    boolean negative = false;
    int quadrant = 0;
    double xa;
    double xb = 0.0;
    xa = x;
    if ( x < 0 ) {
        negative = true;
        xa = -xa;
    }
    if ( xa == 0.0 ) {
        long bits = Double.doubleToRawLongBits ( x );
        if ( bits < 0 ) {
            return -0.0;
        }
        return 0.0;
    }
    if ( xa != xa || xa == Double.POSITIVE_INFINITY ) {
        return Double.NaN;
    }
    if ( xa > 3294198.0 ) {
        double reduceResults[] = new double[3];
        reducePayneHanek ( xa, reduceResults );
        quadrant = ( ( int ) reduceResults[0] ) & 3;
        xa = reduceResults[1];
        xb = reduceResults[2];
    } else if ( xa > 1.5707963267948966 ) {
        final CodyWaite cw = new CodyWaite ( xa );
        quadrant = cw.getK() & 3;
        xa = cw.getRemA();
        xb = cw.getRemB();
    }
    if ( negative ) {
        quadrant ^= 2;  
    }
    switch ( quadrant ) {
    case 0:
        return sinQ ( xa, xb );
    case 1:
        return cosQ ( xa, xb );
    case 2:
        return -sinQ ( xa, xb );
    case 3:
        return -cosQ ( xa, xb );
    default:
        return Double.NaN;
    }
}
