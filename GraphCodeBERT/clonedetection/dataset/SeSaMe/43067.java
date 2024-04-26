public void setExtentSize ( Dimension newExtent ) {
    Dimension oldExtent = getExtentSize();
    if ( !newExtent.equals ( oldExtent ) ) {
        setSize ( newExtent );
        fireStateChanged();
    }
}
