static void warmUp ( LoadingCache<Integer, Integer> map, int start, int end ) {
    checkNotNull ( map );
    for ( int i = start; i < end; i++ ) {
        map.getUnchecked ( i );
    }
}
