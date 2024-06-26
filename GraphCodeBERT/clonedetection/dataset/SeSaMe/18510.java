public long sumThenReset() {
    long sum = base;
    Cell[] as = cells;
    base = 0L;
    if ( as != null ) {
        int n = as.length;
        for ( int i = 0; i < n; ++i ) {
            Cell a = as[i];
            if ( a != null ) {
                sum += a.value;
                a.value = 0L;
            }
        }
    }
    return sum;
}
