public Object getOwnPropertyDescriptor ( final Object key ) {
    final Property property = getMap().findProperty ( key );
    final Global global = Context.getGlobal();
    if ( property != null ) {
        final ScriptFunction get   = property.getGetterFunction ( this );
        final ScriptFunction set   = property.getSetterFunction ( this );
        final boolean configurable = property.isConfigurable();
        final boolean enumerable   = property.isEnumerable();
        final boolean writable     = property.isWritable();
        if ( property.isAccessorProperty() ) {
            return global.newAccessorDescriptor (
                       get != null ?
                       get :
                       UNDEFINED,
                       set != null ?
                       set :
                       UNDEFINED,
                       configurable,
                       enumerable );
        }
        return global.newDataDescriptor ( getWithProperty ( property ), configurable, enumerable, writable );
    }
    final int index = getArrayIndex ( key );
    final ArrayData array = getArray();
    if ( array.has ( index ) ) {
        return array.getDescriptor ( global, index );
    }
    return UNDEFINED;
}
