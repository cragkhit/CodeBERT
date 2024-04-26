@Override
protected ImageWritable doTransform ( ImageWritable image, Random random ) {
    if ( image == null ) {
        return null;
    }
    if ( image.getFrame().imageHeight < outputHeight || image.getFrame().imageWidth < outputWidth )
        throw new UnsupportedOperationException (
            "Output height/width cannot be more than the input image. Requested: " + outputHeight + "+x"
            + outputWidth + ", got " + image.getFrame().imageHeight + "+x"
            + image.getFrame().imageWidth );
    int cropTop = image.getFrame().imageHeight - outputHeight;
    int cropLeft = image.getFrame().imageWidth - outputWidth;
    Mat mat = converter.convert ( image.getFrame() );
    int top = rng.nextInt ( cropTop + 1 );
    int left = rng.nextInt ( cropLeft + 1 );
    y = Math.min ( top, mat.rows() - 1 );
    x = Math.min ( left, mat.cols() - 1 );
    Mat result = mat.apply ( new Rect ( x, y, outputWidth, outputHeight ) );
    return new ImageWritable ( converter.convert ( result ) );
}
