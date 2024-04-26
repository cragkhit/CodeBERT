protected int xPositionForValue ( int value )    {
    int min = slider.getMinimum();
    int max = slider.getMaximum();
    int trackLength = trackRect.width;
    double valueRange = ( double ) max - ( double ) min;
    double pixelsPerValue = ( double ) trackLength / valueRange;
    int trackLeft = trackRect.x;
    int trackRight = trackRect.x + ( trackRect.width - 1 );
    int xPosition;
    if ( !drawInverted() ) {
        xPosition = trackLeft;
        xPosition += Math.round ( pixelsPerValue * ( ( double ) value - min ) );
    } else {
        xPosition = trackRight;
        xPosition -= Math.round ( pixelsPerValue * ( ( double ) value - min ) );
    }
    xPosition = Math.max ( trackLeft, xPosition );
    xPosition = Math.min ( trackRight, xPosition );
    return xPosition;
}
