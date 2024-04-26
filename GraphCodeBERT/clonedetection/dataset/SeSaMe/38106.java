public void updateCursorLater ( Component heavy ) {
    nativeUpdater.postIfNotPending ( heavy, new InvocationEvent
                                     ( Toolkit.getDefaultToolkit(), nativeUpdater ) );
}
