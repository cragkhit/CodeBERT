void setPadding ( String paddingScheme )
throws NoSuchPaddingException {
    if ( paddingScheme == null ) {
        throw new NoSuchPaddingException ( "null padding" );
    }
    if ( paddingScheme.equalsIgnoreCase ( "NoPadding" ) ) {
        padding = null;
    } else if ( paddingScheme.equalsIgnoreCase ( "ISO10126Padding" ) ) {
        padding = new ISO10126Padding ( blockSize );
    } else if ( !paddingScheme.equalsIgnoreCase ( "PKCS5Padding" ) ) {
        throw new NoSuchPaddingException ( "Padding: " + paddingScheme
                                           + " not implemented" );
    }
    if ( ( padding != null ) &&
            ( ( cipherMode == CTR_MODE ) || ( cipherMode == CTS_MODE )
              || ( cipherMode == GCM_MODE ) ) ) {
        padding = null;
        String modeStr = null;
        switch ( cipherMode ) {
        case CTR_MODE:
            modeStr = "CTR";
            break;
        case GCM_MODE:
            modeStr = "GCM";
            break;
        case CTS_MODE:
            modeStr = "CTS";
            break;
        default:
        }
        if ( modeStr != null ) {
            throw new NoSuchPaddingException
            ( modeStr + " mode must be used with NoPadding" );
        }
    }
}
