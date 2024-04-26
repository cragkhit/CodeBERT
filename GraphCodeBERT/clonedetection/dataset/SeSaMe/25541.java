public Map<Field, Value> getValues ( List<? extends Field> theFields ) {
    validateMirrors ( theFields );
    int size = theFields.size();
    JDWP.ReferenceType.GetValues.Field[] queryFields =
        new JDWP.ReferenceType.GetValues.Field[size];
    for ( int i = 0; i < size; i++ ) {
        FieldImpl field = ( FieldImpl ) theFields.get ( i );
        validateFieldAccess ( field );
        if ( !field.isStatic() ) {
            throw new IllegalArgumentException (
                "Attempt to use non-static field with ReferenceType" );
        }
        queryFields[i] = new JDWP.ReferenceType.GetValues.Field (
            field.ref() );
    }
    Map<Field, Value> map = new HashMap<Field, Value> ( size );
    ValueImpl[] values;
    try {
        values = JDWP.ReferenceType.GetValues.
                 process ( vm, this, queryFields ).values;
    } catch ( JDWPException exc ) {
        throw exc.toJDIException();
    }
    if ( size != values.length ) {
        throw new InternalException (
            "Wrong number of values returned from target VM" );
    }
    for ( int i = 0; i < size; i++ ) {
        FieldImpl field = ( FieldImpl ) theFields.get ( i );
        map.put ( field, values[i] );
    }
    return map;
}
