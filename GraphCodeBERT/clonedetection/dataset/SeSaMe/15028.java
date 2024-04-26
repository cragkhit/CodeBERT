public Point getLinkPoint ( Point declination ) {
    int x, y;
    Point linkPoint;
    if ( declination != null ) {
        x = getMap().getZoomed ( declination.x );
        y = getMap().getZoomed ( declination.y );
    } else {
        x = 1;
        y = 0;
    }
    if ( isLeft() ) {
        x = -x;
    }
    if ( y != 0 ) {
        double ctgRect = Math.abs ( ( double ) getContent().getWidth()
                                    / getContent().getHeight() );
        double ctgLine = Math.abs ( ( double ) x / y );
        int absLinkX, absLinkY;
        if ( ctgRect > ctgLine ) {
            absLinkX = Math.abs ( x * getContent().getHeight() / ( 2 * y ) );
            absLinkY = getContent().getHeight() / 2;
        } else {
            absLinkX = getContent().getWidth() / 2;
            absLinkY = Math.abs ( y * getContent().getWidth() / ( 2 * x ) );
        }
        linkPoint = new Point ( getContent().getWidth() / 2
                                + ( x > 0 ? absLinkX : -absLinkX ), getContent().getHeight()
                                / 2 + ( y > 0 ? absLinkY : -absLinkY ) );
    } else {
        linkPoint = new Point ( ( x > 0 ? getContent().getWidth() : 0 ),
                                ( getContent().getHeight() / 2 ) );
    }
    linkPoint.translate ( getContent().getX(), getContent().getY() );
    convertPointToMap ( linkPoint );
    return linkPoint;
}
