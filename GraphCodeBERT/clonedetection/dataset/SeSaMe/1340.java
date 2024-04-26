TrieEntry<K, V> getEntry ( final Object k ) {
    final K key = castKey ( k );
    if ( key == null ) {
        return null;
    }
    final int lengthInBits = lengthInBits ( key );
    final TrieEntry<K, V> entry = getNearestEntryForKey ( key, lengthInBits );
    return !entry.isEmpty() && compareKeys ( key, entry.key ) ? entry : null;
}
