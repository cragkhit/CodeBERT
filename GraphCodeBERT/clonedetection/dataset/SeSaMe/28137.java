public static <T> Optional<T> ofNullable ( T value ) {
    return value == null ? empty() : of ( value );
}
