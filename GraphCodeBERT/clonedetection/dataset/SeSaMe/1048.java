public static <E> List<E> sum ( final List<? extends E> list1, final List<? extends E> list2 ) {
    return subtract ( union ( list1, list2 ), intersection ( list1, list2 ) );
}
