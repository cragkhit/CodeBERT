public Type elemtype ( Type t ) {
    switch ( t.getTag() ) {
    case WILDCARD:
        return elemtype ( wildUpperBound ( t ) );
    case ARRAY:
        return ( ( ArrayType ) t ).elemtype;
    case FORALL:
        return elemtype ( ( ( ForAll ) t ).qtype );
    case ERROR:
        return t;
    default:
        return null;
    }
}
