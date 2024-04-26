protected void removeFromSource() {
    if ( source != null ) {
        source.removeMouseListener ( this );
        source.removeMouseMotionListener ( this );
        if ( focusComponent != null &&
                focusComponent == destination && !dispatchedEvent &&
                ( focusComponent instanceof JTextField ) ) {
            ( ( JTextField ) focusComponent ).selectAll();
        }
    }
    source = destination = null;
}
