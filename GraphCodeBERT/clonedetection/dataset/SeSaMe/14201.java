public void runOperation ( IProgressMonitor monitor ) throws JavaModelException {
    IJavaModelStatus status = verify();
    if ( !status.isOK() ) {
        throw new JavaModelException ( status );
    }
    try {
        if ( isReadOnly() ) {
            run ( monitor );
        } else {
            ResourcesPlugin.getWorkspace().run ( this, getSchedulingRule(), IWorkspace.AVOID_UPDATE, monitor );
        }
    } catch ( CoreException ce ) {
        if ( ce instanceof JavaModelException ) {
            throw ( JavaModelException ) ce;
        } else {
            if ( ce.getStatus().getCode() == IResourceStatus.OPERATION_FAILED ) {
                Throwable e = ce.getStatus().getException();
                if ( e instanceof JavaModelException ) {
                    throw ( JavaModelException ) e;
                }
            }
            throw new JavaModelException ( ce );
        }
    }
}
