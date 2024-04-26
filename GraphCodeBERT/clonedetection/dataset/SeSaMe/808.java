public AuditListener createListener ( Task task ) throws IOException {
    final AuditListener listener;
    if ( type != null
            && E_XML.equals ( type.getValue() ) ) {
        listener = createXmlLogger ( task );
    } else {
        listener = createDefaultLogger ( task );
    }
    return listener;
}
