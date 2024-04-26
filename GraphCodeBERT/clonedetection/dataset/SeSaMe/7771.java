public static <T> Optional<T> ofNullable ( T value ) {
    if ( value == null ) {
        return empty();
    }
    return new Optional<> ( value );
}
