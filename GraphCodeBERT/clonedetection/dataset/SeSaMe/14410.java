protected void traverseDelta (
    IJavaElementDelta delta,
    IPackageFragmentRoot root,
    IJavaProject project ) {
    boolean processChildren = true;
    Openable element = ( Openable ) delta.getElement();
    switch ( element.getElementType() ) {
    case IJavaElement.JAVA_PROJECT :
        project = ( IJavaProject ) element;
        break;
    case IJavaElement.PACKAGE_FRAGMENT_ROOT :
        root = ( IPackageFragmentRoot ) element;
        break;
    case IJavaElement.COMPILATION_UNIT :
        CompilationUnit cu = ( CompilationUnit ) element;
        if ( cu.isWorkingCopy() && !cu.isPrimary() ) {
            return;
        }
    case IJavaElement.CLASS_FILE :
        processChildren = false;
        break;
    }
    switch ( delta.getKind() ) {
    case IJavaElementDelta.ADDED :
        elementAdded ( element );
        break;
    case IJavaElementDelta.REMOVED :
        elementRemoved ( element );
        break;
    case IJavaElementDelta.CHANGED :
        if ( ( delta.getFlags() & IJavaElementDelta.F_CONTENT ) != 0 ) {
            elementChanged ( element );
        }
        break;
    }
    if ( processChildren ) {
        IJavaElementDelta[] children = delta.getAffectedChildren();
        for ( int i = 0; i < children.length; i++ ) {
            IJavaElementDelta childDelta = children[i];
            traverseDelta ( childDelta, root, project );
        }
    }
}
