public Object getInitialValue() {
    if ( isMethod() || ( getValue() == null ) || ( !isFinal() ) || ( status != INLINED ) ) {
        return null;
    }
    return ( ( Expression ) getValue() ).getValue();
}
