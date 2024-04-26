@Override
public T create() {
    if ( iConstructor == null ) {
        findConstructor();
    }
    try {
        return iConstructor.newInstance ( iArgs );
    } catch ( final InstantiationException ex ) {
        throw new FunctorException ( "InstantiateFactory: InstantiationException", ex );
    } catch ( final IllegalAccessException ex ) {
        throw new FunctorException ( "InstantiateFactory: Constructor must be public", ex );
    } catch ( final InvocationTargetException ex ) {
        throw new FunctorException ( "InstantiateFactory: Constructor threw an exception", ex );
    }
}
