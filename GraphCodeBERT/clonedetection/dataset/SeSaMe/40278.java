public int getProfileClass() {
    byte[] theHeader;
    int theClassSig, theClass;
    if ( deferralInfo != null ) {
        return deferralInfo.profileClass;  
    }
    theHeader = getData ( icSigHead );
    theClassSig = intFromBigEndian ( theHeader, icHdrDeviceClass );
    switch ( theClassSig ) {
    case icSigInputClass:
        theClass = CLASS_INPUT;
        break;
    case icSigDisplayClass:
        theClass = CLASS_DISPLAY;
        break;
    case icSigOutputClass:
        theClass = CLASS_OUTPUT;
        break;
    case icSigLinkClass:
        theClass = CLASS_DEVICELINK;
        break;
    case icSigColorSpaceClass:
        theClass = CLASS_COLORSPACECONVERSION;
        break;
    case icSigAbstractClass:
        theClass = CLASS_ABSTRACT;
        break;
    case icSigNamedColorClass:
        theClass = CLASS_NAMEDCOLOR;
        break;
    default:
        throw new IllegalArgumentException ( "Unknown profile class" );
    }
    return theClass;
}
