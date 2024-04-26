public void applyShape ( Region shape ) {
    if ( XlibUtil.isShapingSupported() ) {
        if ( shapeLog.isLoggable ( PlatformLogger.Level.FINER ) ) {
            shapeLog.finer (
                "*** INFO: Setting shape: PEER: " + this
                + "; WINDOW: " + getWindow()
                + "; TARGET: " + target
                + "; SHAPE: " + shape );
        }
        XToolkit.awtLock();
        try {
            if ( shape != null ) {
                int scale = getScale();
                if ( scale != 1 ) {
                    shape = shape.getScaledRegion ( scale, scale );
                }
                XlibWrapper.SetRectangularShape (
                    XToolkit.getDisplay(),
                    getWindow(),
                    shape.getLoX(), shape.getLoY(),
                    shape.getHiX(), shape.getHiY(),
                    ( shape.isRectangular() ? null : shape )
                );
            } else {
                XlibWrapper.SetRectangularShape (
                    XToolkit.getDisplay(),
                    getWindow(),
                    0, 0,
                    0, 0,
                    null
                );
            }
        } finally {
            XToolkit.awtUnlock();
        }
    } else {
        if ( shapeLog.isLoggable ( PlatformLogger.Level.FINER ) ) {
            shapeLog.finer ( "*** WARNING: Shaping is NOT supported!" );
        }
    }
}
