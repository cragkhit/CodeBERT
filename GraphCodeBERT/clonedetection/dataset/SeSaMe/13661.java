public IJavaModelStatus getJavaModelStatus() {
    IStatus status = getStatus();
    if ( status instanceof IJavaModelStatus ) {
        return ( IJavaModelStatus ) status;
    } else {
        return new JavaModelStatus ( this.nestedCoreException );
    }
}
