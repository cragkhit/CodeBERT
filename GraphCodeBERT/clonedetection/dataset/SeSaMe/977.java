protected void addNodeToCache ( final Node<E> node ) {
    if ( isCacheFull() ) {
        return;
    }
    final Node<E> nextCachedNode = firstCachedNode;
    node.previous = null;
    node.next = nextCachedNode;
    node.setValue ( null );
    firstCachedNode = node;
    cacheSize++;
}
