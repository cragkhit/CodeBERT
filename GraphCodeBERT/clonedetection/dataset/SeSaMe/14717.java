public IFile getEnclosingIFile ( Element elem ) {
    IElementInfo impl = ( IElementInfo ) elem;
    String name = impl.getFileName();
    if ( name == null ) {
        return null;
    }
    IFile file = _javaProject.getProject().getParent().getFile ( new Path ( name ) );
    return file;
}
