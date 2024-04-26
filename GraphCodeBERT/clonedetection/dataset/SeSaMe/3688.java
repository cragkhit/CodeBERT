public boolean isValidPoint ( double x ) {
    if ( x < knots[0] ||
            x > knots[n] ) {
        return false;
    } else {
        return true;
    }
}
