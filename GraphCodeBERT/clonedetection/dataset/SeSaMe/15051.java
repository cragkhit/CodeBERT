public Dimension getViewportSize() {
    if ( getParent() instanceof JViewport ) {
        JViewport mapViewport = ( JViewport ) getParent();
        return mapViewport == null ? null : mapViewport.getSize();
    }
    return null;
}
