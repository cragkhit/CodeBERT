protected void updateNode ( MindMapNode node ) {
    for ( NodeSelectionListener listener : mNodeSelectionListeners ) {
        listener.onUpdateNodeHook ( node );
    }
}
