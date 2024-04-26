public static <K, T, V> MultiDimensionalMap<K, T, V> newTreeBackedMap() {
    return new MultiDimensionalMap<> ( new TreeMap<Pair<K, T>, V>() );
}
