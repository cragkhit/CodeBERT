public static int getIntFromField ( Field field, Object object ) {
    try {
        return field.getInt ( object );
    } catch ( final IllegalAccessException exception ) {
        throw new IllegalStateException ( exception );
    }
}
