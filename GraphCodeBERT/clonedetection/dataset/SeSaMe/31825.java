@CallerSensitive
@ForceInline 
public int getInt ( Object obj )
throws IllegalArgumentException, IllegalAccessException {
    if ( !override ) {
        Class<?> caller = Reflection.getCallerClass();
        checkAccess ( caller, obj );
    }
    return getFieldAccessor ( obj ).getInt ( obj );
}
