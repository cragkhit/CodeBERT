public static <T> List<List<T>> partition ( List<T> list, int size ) {
    checkNotNull ( list );
    checkArgument ( size > 0 );
    return ( list instanceof RandomAccess )
           ? new RandomAccessPartition<> ( list, size )
           : new Partition<> ( list, size );
}
