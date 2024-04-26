boolean isExpired ( ReferenceEntry<K, V> entry, long now ) {
    checkNotNull ( entry );
    if ( expiresAfterAccess() && ( now - entry.getAccessTime() >= expireAfterAccessNanos ) ) {
        return true;
    }
    if ( expiresAfterWrite() && ( now - entry.getWriteTime() >= expireAfterWriteNanos ) ) {
        return true;
    }
    return false;
}
