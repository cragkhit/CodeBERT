long getMetaspaceKlass() {
    if ( HotSpotJVMCIRuntime.getHostWordKind() == JavaKind.Long ) {
        return UNSAFE.getLong ( javaClass, config().klassOffset );
    }
    return UNSAFE.getInt ( javaClass, config().klassOffset ) & 0xFFFFFFFFL;
}
