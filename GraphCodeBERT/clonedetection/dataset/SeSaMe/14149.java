protected boolean computeChildren ( OpenableElementInfo info, IResource underlyingResource ) throws JavaModelException {
    try {
        if ( underlyingResource.getType() == IResource.FOLDER || underlyingResource.getType() == IResource.PROJECT ) {
            ArrayList vChildren = new ArrayList ( 5 );
            IContainer rootFolder = ( IContainer ) underlyingResource;
            char[][] inclusionPatterns = fullInclusionPatternChars();
            char[][] exclusionPatterns = fullExclusionPatternChars();
            computeFolderChildren ( rootFolder, !Util.isExcluded ( rootFolder, inclusionPatterns, exclusionPatterns ), CharOperation.NO_STRINGS, vChildren, inclusionPatterns, exclusionPatterns );
            if ( !vChildren.isEmpty() ) {
                IJavaElement[] children = new IJavaElement[vChildren.size()];
                vChildren.toArray ( children );
                info.setChildren ( children );
            } else {
                info.setChildren ( JavaElement.NO_ELEMENTS );
            }
        }
    } catch ( JavaModelException e ) {
        info.setChildren ( new IJavaElement[] {} );
        throw e;
    }
    return true;
}
