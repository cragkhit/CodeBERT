public Point removePoint ( String id ) {
    Point removePoint = null;
    for ( Point point : points )
        if ( id.equals ( point.getId() ) ) {
            removePoint = point;
        }
    if ( removePoint != null ) {
        points.remove ( removePoint );
    }
    return removePoint;
}
