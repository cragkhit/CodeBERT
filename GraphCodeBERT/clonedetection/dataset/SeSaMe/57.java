public void schedule ( @NonNull Node<K, V> node ) {
    Node<K, V> sentinel = findBucket ( node.getVariableTime() );
    link ( sentinel, node );
}
