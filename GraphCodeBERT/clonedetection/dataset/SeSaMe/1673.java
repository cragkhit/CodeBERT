public static Predicate<Object> instanceOfPredicate ( final Class<?> type ) {
    if ( type == null ) {
        throw new NullPointerException ( "The type to check instanceof must not be null" );
    }
    return new InstanceofPredicate ( type );
}
