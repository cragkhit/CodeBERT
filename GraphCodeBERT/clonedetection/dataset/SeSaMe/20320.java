void runIterations ( int n ) {
    for ( int k = 0; k < n; k++ ) {
        int s = k;
        for ( int i = 0; i < n; i++ ) {
            if ( i % 2 == 0 ) {
                s += i * 10;
            } else {
                s -= i * 10;
            }
        }
    }
}
