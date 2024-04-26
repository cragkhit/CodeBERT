@GwtIncompatible 
static Thread newThread ( String name, Runnable runnable ) {
    checkNotNull ( name );
    checkNotNull ( runnable );
    Thread result = platformThreadFactory().newThread ( runnable );
    try {
        result.setName ( name );
    } catch ( SecurityException e ) {
    }
    return result;
}
