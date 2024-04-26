public NodeHook createNodeHook ( String hookName ) {
    logger.finest ( "CreateNodeHook: " + hookName );
    HookDescriptorPluginAction descriptor = getHookDescriptor ( hookName );
    return ( NodeHook ) createJavaHook ( hookName, descriptor );
}
