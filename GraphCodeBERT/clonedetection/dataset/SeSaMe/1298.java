@Deprecated
public static <T> T find ( final Iterable<T> collection, final Predicate<? super T> predicate ) {
    return predicate != null ? IterableUtils.find ( collection, predicate ) : null;
}
