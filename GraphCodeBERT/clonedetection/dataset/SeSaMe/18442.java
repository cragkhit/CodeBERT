@SuppressWarnings ( "unchecked" )
public static <E> Function<E, E> identity() {
    return ( Function<E, E> ) IdentityFunction.INSTANCE;
}
