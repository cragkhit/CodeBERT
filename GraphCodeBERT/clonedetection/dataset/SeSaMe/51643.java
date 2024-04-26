public List<Type> typeCheckArgs ( SymbolTable stable ) throws TypeCheckError {
    final List<Type> result = new ArrayList<>();
    for ( Expression exp : _arguments ) {
        result.add ( exp.typeCheck ( stable ) );
    }
    return result;
}
