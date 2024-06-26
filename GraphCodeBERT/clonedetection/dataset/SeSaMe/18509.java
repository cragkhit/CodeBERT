public long sum() {
    long sum = base;
    Cell[] as = cells;
    if ( as != null ) {
        int n = as.length;
        for ( int i = 0; i < n; ++i ) {
            Cell a = as[i];
            if ( a != null ) {
                sum += a.value;
            }
        }
    }
    return sum;
}
