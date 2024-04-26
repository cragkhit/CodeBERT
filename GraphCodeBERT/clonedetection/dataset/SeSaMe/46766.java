public static SurfaceType getSurfaceType ( XRGraphicsConfig gc,
        int transparency ) {
    SurfaceType sType = null;
    switch ( transparency ) {
    case Transparency.OPAQUE:
        sType = XRSurfaceData.IntRgbX11;
        break;
    case Transparency.BITMASK:
    case Transparency.TRANSLUCENT:
        sType = XRSurfaceData.IntArgbPreX11;
        break;
    }
    return sType;
}
