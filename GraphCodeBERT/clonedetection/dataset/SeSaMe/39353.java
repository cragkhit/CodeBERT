public void dropComplete ( boolean success ) throws InvalidDnDOperationException {
    DropTargetContextPeer peer = getDropTargetContextPeer();
    if ( peer != null ) {
        peer.dropComplete ( success );
    }
}
