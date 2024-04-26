public long sum() {
    Cell[] cs = cells;
    long sum = base;
    if ( cs != null ) {
        for ( Cell c : cs )
            if ( c != null ) {
                sum += c.value;
            }
    }
    return sum;
}
