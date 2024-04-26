public Point getCenterPoint() throws HeadlessException {
    Rectangle usableBounds =
        SunGraphicsEnvironment.getUsableBounds ( getDefaultScreenDevice() );
    return new Point ( ( usableBounds.width / 2 ) + usableBounds.x,
                       ( usableBounds.height / 2 ) + usableBounds.y );
}
