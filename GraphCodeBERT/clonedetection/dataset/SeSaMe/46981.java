public void notifyValue ( XScrollbar obj, int type, int v, boolean isAdjusting ) {
    if ( log.isLoggable ( PlatformLogger.Level.FINE ) ) {
        log.fine ( "Notify value changed on " + obj + " to " + v );
    }
    int value = obj.getValue();
    if ( obj == vsb ) {
        scrollVertical ( v - value );
        int oldSel = eventIndex;
        int newSel = eventIndex + v - value;
        if ( mouseDraggedOutVertically && !isSelected ( newSel ) ) {
            selectItem ( newSel );
            eventIndex = newSel;
            repaint ( oldSel, eventIndex, PAINT_ITEMS );
            setFocusIndex ( newSel );
            repaint ( PAINT_FOCUS );
        }
    } else if ( ( XHorizontalScrollbar ) obj == hsb ) {
        scrollHorizontal ( v - value );
    }
}
