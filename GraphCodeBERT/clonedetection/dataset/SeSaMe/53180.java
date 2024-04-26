public AnnotationEntry[] getAnnotationEntries() {
    if ( annotations == null ) {
        annotations = AnnotationEntry.createAnnotationEntries ( getAttributes() );
    }
    return annotations;
}
