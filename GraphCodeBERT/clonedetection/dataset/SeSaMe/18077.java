@Deprecated
public static void append ( CharSequence from, File to, Charset charset ) throws IOException {
    asCharSink ( to, charset, FileWriteMode.APPEND ).write ( from );
}
