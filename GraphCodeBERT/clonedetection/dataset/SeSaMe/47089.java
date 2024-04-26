public void cleanup ( long time ) {
    if ( dndInProgress ) {
        if ( dragProtocol != null ) {
            dragProtocol.sendLeaveMessage ( time );
        }
        if ( targetAction != DnDConstants.ACTION_NONE ) {
            dragExit ( xRoot, yRoot );
        }
        dragDropFinished ( false, DnDConstants.ACTION_NONE, xRoot, yRoot );
    }
    Iterator<XDragSourceProtocol> dragProtocols =
        XDragAndDropProtocols.getDragSourceProtocols();
    while ( dragProtocols.hasNext() ) {
        XDragSourceProtocol dragProtocol = dragProtocols.next();
        try {
            dragProtocol.cleanup();
        } catch ( XException xe ) {
        }
    }
    dndInProgress = false;
    dragInProgress = false;
    dragRootWindow = 0;
    sourceFormats = null;
    sourceActions = DnDConstants.ACTION_NONE;
    sourceAction = DnDConstants.ACTION_NONE;
    eventState = 0;
    xRoot = 0;
    yRoot = 0;
    cleanupTargetInfo();
    removeDnDGrab ( time );
}
