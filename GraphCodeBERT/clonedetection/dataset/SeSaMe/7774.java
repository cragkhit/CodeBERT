public T orElse ( T other ) {
    if ( isPresent() ) {
        return get();
    }
    return other;
}
