public void setIconImage ( final Image image ) {
    checkEventsProcessingPermission();
    checkFeatureSupport ( Feature.ICON_IMAGE );
    peer.setIconImage ( image );
}
