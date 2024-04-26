protected QuadTree findIndex ( INDArray coordinates ) {
    boolean left = ( coordinates.getDouble ( 0 ) <= ( boundary.getX() + boundary.getHw() / 2 ) );
    boolean top = ( coordinates.getDouble ( 1 ) <= ( boundary.getY() + boundary.getHh() / 2 ) );
    QuadTree index = getNorthWest();
    if ( left ) {
        if ( !top ) {
            index = getSouthWest();
        }
    } else {
        if ( top ) {
            index = getNorthEast();
        } else {
            index = getSouthEast();
        }
    }
    return index;
}
