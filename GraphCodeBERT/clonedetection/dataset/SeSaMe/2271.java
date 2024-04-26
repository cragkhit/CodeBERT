@SuppressWarnings ( "unchecked" ) 
public static <T extends Serializable> T roundtrip ( final T msg ) {
    return ( T ) deserialize ( serialize ( msg ) );
}
