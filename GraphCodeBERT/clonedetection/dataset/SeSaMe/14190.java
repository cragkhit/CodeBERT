protected void createFile ( IContainer folder, String name, InputStream contents, boolean forceFlag ) throws JavaModelException {
    IFile file = folder.getFile ( new Path ( name ) );
    try {
        file.create (
            contents,
            forceFlag ? IResource.FORCE | IResource.KEEP_HISTORY : IResource.KEEP_HISTORY,
            getSubProgressMonitor ( 1 ) );
        setAttribute ( HAS_MODIFIED_RESOURCE_ATTR, TRUE );
    } catch ( CoreException e ) {
        throw new JavaModelException ( e );
    }
}
