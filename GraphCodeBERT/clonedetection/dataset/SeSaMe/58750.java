public Type unboxedType ( Type t ) {
    for ( int i = 0; i < syms.boxedName.length; i++ ) {
        Name box = syms.boxedName[i];
        if ( box != null &&
                asSuper ( t, syms.enterClass ( syms.java_base, box ) ) != null ) {
            return syms.typeOfTag[i];
        }
    }
    return Type.noType;
}
