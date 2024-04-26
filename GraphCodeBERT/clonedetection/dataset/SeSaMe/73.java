final boolean isComputingAsync ( Node<?, ?> node ) {
    return isAsync && !Async.isReady ( ( CompletableFuture<?> ) node.getValue() );
}
