@VisibleForTesting
static ImmutableSet<Class<?>> flattenHierarchy ( Class<?> concreteClass ) {
    try {
        return flattenHierarchyCache.getUnchecked ( concreteClass );
    } catch ( UncheckedExecutionException e ) {
        throw Throwables.propagate ( e.getCause() );
    }
}
