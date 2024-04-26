public static <T> List<List<T>> partition ( final List<T> list, final int size ) {
    if ( list == null ) {
        throw new NullPointerException ( "List must not be null" );
    }
    if ( size <= 0 ) {
        throw new IllegalArgumentException ( "Size must be greater than 0" );
    }
    return new Partition<> ( list, size );
}
