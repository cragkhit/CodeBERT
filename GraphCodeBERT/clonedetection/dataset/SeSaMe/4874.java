public void add ( final BSPTree<S> node ) {
    for ( final BSPTree<S> existing : list ) {
        if ( node == existing ) {
            return;
        }
    }
    list.add ( node );
}
