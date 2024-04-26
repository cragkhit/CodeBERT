public synchronized void setLabel ( String label ) {
    this.label = label;
    MenuItemPeer peer = ( MenuItemPeer ) this.peer;
    if ( peer != null ) {
        peer.setLabel ( label );
    }
}
