public City getClosestCity ( double x,
                             double y ) {
    City closest = null;
    double min = Double.POSITIVE_INFINITY;
    for ( City c : cities ) {
        final double d = c.distance ( x, y );
        if ( d < min ) {
            min = d;
            closest = c;
        }
    }
    return closest;
}
