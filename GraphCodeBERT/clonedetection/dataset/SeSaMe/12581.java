public char[][] getParameterNames() {
    List<NdMethodParameter> params = getMethodParameters();
    int index = 0;
    char[][] result = new char[params.size()][];
    for ( int idx = 0; idx < result.length; idx++ ) {
        NdMethodParameter param = params.get ( idx );
        if ( !param.isCompilerDefined() ) {
            result[index] = param.getName().getChars();
            index++;
        }
    }
    return CharArrayUtils.subarray ( result, 0, index );
}
