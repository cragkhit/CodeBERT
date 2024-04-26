public static void awaitClear ( final WeakReference<?> ref ) {
    awaitDone (
    new FinalizationPredicate() {
        public boolean isDone() {
            return ref.get() == null;
        }
    } );
}
