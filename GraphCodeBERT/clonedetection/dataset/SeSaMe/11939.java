public static LookupStrategy get ( char[] moduleName ) {
    if ( moduleName == ModuleBinding.ANY ) {
        return Any;
    }
    if ( moduleName == ModuleBinding.ANY_NAMED ) {
        return AnyNamed;
    }
    if ( moduleName == ModuleBinding.UNNAMED ) {
        return Unnamed;
    }
    return Named;
}
