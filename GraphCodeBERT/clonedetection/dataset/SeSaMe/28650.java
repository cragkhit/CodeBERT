public long sumThenReset() {
    Cell[] cs = cells;
    long sum = getAndSetBase ( 0L );
    if ( cs != null ) {
        for ( Cell c : cs ) {
            if ( c != null ) {
                sum += c.getAndSet ( 0L );
            }
        }
    }
    return sum;
}
