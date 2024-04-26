public double sumThenReset() {
    Cell[] cs = cells;
    double sum = Double.longBitsToDouble ( getAndSetBase ( 0L ) );
    if ( cs != null ) {
        for ( Cell c : cs ) {
            if ( c != null ) {
                sum += Double.longBitsToDouble ( c.getAndSet ( 0L ) );
            }
        }
    }
    return sum;
}
