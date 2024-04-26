public void propertyChange ( PropertyChangeEvent evt ) {
    Object oldValue = evt.getOldValue();
    Object newValue = evt.getNewValue();
    if ( ( oldValue instanceof Document ) || ( newValue instanceof Document ) ) {
        setDot ( 0 );
        if ( oldValue != null ) {
            ( ( Document ) oldValue ).removeDocumentListener ( this );
        }
        if ( newValue != null ) {
            ( ( Document ) newValue ).addDocumentListener ( this );
        }
    } else if ( "enabled".equals ( evt.getPropertyName() ) ) {
        Boolean enabled = ( Boolean ) evt.getNewValue();
        if ( component.isFocusOwner() ) {
            if ( enabled == Boolean.TRUE ) {
                if ( component.isEditable() ) {
                    setVisible ( true );
                }
                setSelectionVisible ( true );
            } else {
                setVisible ( false );
                setSelectionVisible ( false );
            }
        }
    } else if ( "caretWidth".equals ( evt.getPropertyName() ) ) {
        Integer newWidth = ( Integer ) evt.getNewValue();
        if ( newWidth != null ) {
            caretWidth = newWidth.intValue();
        } else {
            caretWidth = -1;
        }
        repaint();
    } else if ( "caretAspectRatio".equals ( evt.getPropertyName() ) ) {
        Number newRatio = ( Number ) evt.getNewValue();
        if ( newRatio != null ) {
            aspectRatio = newRatio.floatValue();
        } else {
            aspectRatio = -1;
        }
        repaint();
    }
}
