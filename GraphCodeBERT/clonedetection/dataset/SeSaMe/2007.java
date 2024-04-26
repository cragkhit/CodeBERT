public static String toEncodedString ( final byte[] bytes, final Charset charset ) {
    return new String ( bytes, charset != null ? charset : Charset.defaultCharset() );
}
