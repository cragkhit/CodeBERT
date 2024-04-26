public void discardWorkingCopy ( ICompilationUnit wc ) {
    if ( null == wc ) {
        return;
    }
    if ( AptPlugin.DEBUG_GFM ) AptPlugin.trace (
            "discarding working copy: " + wc.getElementName() ); 
    try {
        wc.discardWorkingCopy();
    } catch ( JavaModelException e ) {
        AptPlugin.log ( e, "Unable to discard working copy: " + wc.getElementName() ); 
    }
}
