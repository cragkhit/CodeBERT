@Override
public T transform ( final T input ) {
    if ( input == null ) {
        return null;
    }
    return PrototypeFactory.prototypeFactory ( input ).create();
}
