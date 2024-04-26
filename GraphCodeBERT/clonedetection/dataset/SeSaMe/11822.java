public final static int archiveFormat ( String name ) {
    int lastDot = name.lastIndexOf ( '.' );
    if ( lastDot == -1 ) {
        return -1;    
    }
    if ( name.lastIndexOf ( File.separatorChar ) > lastDot ) {
        return -1;    
    }
    int length = name.length();
    int extensionLength = length - lastDot - 1;
    if ( extensionLength == EXTENSION_java.length() ) {
        for ( int i = extensionLength - 1; i >= 0; i-- ) {
            if ( Character.toLowerCase ( name.charAt ( length - extensionLength + i ) ) != EXTENSION_java.charAt ( i ) ) {
                break; 
            }
            if ( i == 0 ) {
                return -1; 
            }
        }
    }
    if ( extensionLength == EXTENSION_class.length() ) {
        for ( int i = extensionLength - 1; i >= 0; i-- ) {
            if ( Character.toLowerCase ( name.charAt ( length - extensionLength + i ) ) != EXTENSION_class.charAt ( i ) ) {
                return ZIP_FILE; 
            }
        }
        return -1; 
    }
    if ( extensionLength == EXTENSION_jmod.length() ) {
        for ( int i = extensionLength - 1; i >= 0; i-- ) {
            if ( Character.toLowerCase ( name.charAt ( length - extensionLength + i ) ) != EXTENSION_jmod.charAt ( i ) ) {
                return ZIP_FILE; 
            }
        }
        return JMOD_FILE;
    }
    return ZIP_FILE; 
}
