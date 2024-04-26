public WritableRaster createCompatibleDestRaster ( Raster src ) {
    Rectangle2D r = getBounds2D ( src );
    return src.createCompatibleWritableRaster ( ( int ) r.getX(),
            ( int ) r.getY(),
            ( int ) r.getWidth(),
            ( int ) r.getHeight() );
}
