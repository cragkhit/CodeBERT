public GraphBuilder addVertex ( String vertexName, GraphVertex vertex, String... vertexInputs ) {
    initBuilderIfReq();
    editedConfigBuilder.addVertex ( vertexName, vertex, vertexInputs );
    editedVertices.add ( vertexName );
    return this;
}
