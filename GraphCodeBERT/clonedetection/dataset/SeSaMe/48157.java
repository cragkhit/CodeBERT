public String getDescription() {
    Klass k = getKlass();
    if ( k instanceof InstanceKlass ) {
        return k.getName().asString().replace ( '/', '.' );
    } else if ( k instanceof ArrayKlass ) {
        ArrayKlass ak = ( ArrayKlass ) k;
        if ( k instanceof TypeArrayKlass ) {
            TypeArrayKlass tak = ( TypeArrayKlass ) ak;
            return tak.getElementTypeName() + "[]";
        } else if ( k instanceof ObjArrayKlass ) {
            ObjArrayKlass oak = ( ObjArrayKlass ) ak;
            Klass bottom = oak.getBottomKlass();
            int dim = ( int ) oak.getDimension();
            StringBuffer buf = new StringBuffer();
            if ( bottom instanceof TypeArrayKlass ) {
                buf.append ( ( ( TypeArrayKlass ) bottom ).getElementTypeName() );
            } else if ( bottom instanceof InstanceKlass ) {
                buf.append ( bottom.getName().asString().replace ( '/', '.' ) );
            } else {
                throw new RuntimeException ( "should not reach here" );
            }
            for ( int i = 0; i < dim; i++ ) {
                buf.append ( "[]" );
            }
            return buf.toString();
        }
    }
    return getInternalName ( k );
}
