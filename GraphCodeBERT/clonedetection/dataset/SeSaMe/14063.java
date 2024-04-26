boolean subtypesIncludeSupertypeOf ( IType type ) {
    String superclassName = null;
    try {
        superclassName = type.getSuperclassName();
    } catch ( JavaModelException e ) {
        if ( DEBUG ) {
            e.printStackTrace();
        }
        return false;
    }
    if ( superclassName == null ) {
        superclassName = "Object"; 
    }
    if ( hasSubtypeNamed ( superclassName ) ) {
        return true;
    }
    String[] interfaceNames = null;
    try {
        interfaceNames = type.getSuperInterfaceNames();
    } catch ( JavaModelException e ) {
        if ( DEBUG ) {
            e.printStackTrace();
        }
        return false;
    }
    for ( int i = 0, length = interfaceNames.length; i < length; i++ ) {
        String interfaceName = interfaceNames[i];
        if ( hasSubtypeNamed ( interfaceName ) ) {
            return true;
        }
    }
    return false;
}
