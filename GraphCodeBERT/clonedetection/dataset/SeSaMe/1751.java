@SuppressWarnings ( "unchecked" )
public static <T> Transformer<T, String> stringValueTransformer() {
    return ( Transformer<T, String> ) INSTANCE;
}
