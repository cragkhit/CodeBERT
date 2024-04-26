protected void save ( Model model, String filename ) {
    try {
        ModelSerializer.writeModel ( model, filename, true );
    } catch ( IOException e ) {
        throw new RuntimeException ( e );
    }
}
