public Point getPoint ( String id ) {
    for ( Point point : points )
        if ( id.equals ( point.getId() ) ) {
            return point;
        }
    return null;
}
