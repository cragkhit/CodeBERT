protected void buildMethodInfo ( Content methodsContentTree ) throws DocletException  {
    if ( configuration.nocomment ) {
        return;
    }
    buildMethodDescription ( methodsContentTree );
    buildMethodTags ( methodsContentTree );
}
