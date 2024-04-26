public static String fileNameToClassName ( String filename ) {
    assert isClassFile ( filename );
    final char nameSeparator = '/';
    return filename.substring ( 0, filename.length() - CLASSFILE_EXT.length() )
           .replace ( nameSeparator, '.' );
}
