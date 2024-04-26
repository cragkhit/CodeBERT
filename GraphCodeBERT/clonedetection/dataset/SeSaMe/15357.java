@SuppressWarnings ( "unchecked" )
static <T> T reserialize ( T object ) {
    checkNotNull ( object );
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    try {
        ObjectOutputStream out = new ObjectOutputStream ( bytes );
        out.writeObject ( object );
        ObjectInputStream in = new ObjectInputStream ( new ByteArrayInputStream ( bytes.toByteArray() ) );
        return ( T ) in.readObject();
    } catch ( IOException | ClassNotFoundException e ) {
        throw new RuntimeException ( e );
    }
}
