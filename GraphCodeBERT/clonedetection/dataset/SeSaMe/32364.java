  MethodType asCollectorType ( Class<?> arrayType, int pos, int arrayLength ) {
    assert ( parameterCount() >= 1 );
    assert ( pos < ptypes.length );
    assert ( ptypes[pos].isAssignableFrom ( arrayType ) );
    MethodType res;
    if ( arrayType == Object[].class ) {
        res = genericMethodType ( arrayLength );
        if ( rtype != Object.class ) {
            res = res.changeReturnType ( rtype );
        }
    } else {
        Class<?> elemType = arrayType.getComponentType();
        assert ( elemType != null );
        res = methodType ( rtype, Collections.nCopies ( arrayLength, elemType ) );
    }
    if ( ptypes.length == 1 ) {
        return res;
    } else {
        if ( pos < ptypes.length - 1 ) {
            res = res.insertParameterTypes ( arrayLength, Arrays.copyOfRange ( ptypes, pos + 1, ptypes.length ) );
        }
        return res.insertParameterTypes ( 0, Arrays.copyOf ( ptypes, pos ) );
    }
}
