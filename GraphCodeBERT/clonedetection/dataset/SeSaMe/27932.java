public Graph<T> transpose() {
    Builder<T> builder = new Builder<>();
    nodes.forEach ( builder::addNode );
    edges.keySet().forEach ( u -> {
        edges.get ( u ).forEach ( v -> builder.addEdge ( v, u ) );
    } );
    return builder.build();
}
