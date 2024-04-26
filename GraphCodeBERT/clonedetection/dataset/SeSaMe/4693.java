void split ( final Circle splitCircle,
             final List<Edge> outsideList, final List<Edge> insideList ) {
    final double edgeStart        = circle.getPhase ( start.getLocation().getVector() );
    final Arc    arc              = circle.getInsideArc ( splitCircle );
    final double arcRelativeStart = PlaneAngleRadians.normalize ( arc.getInf(), edgeStart + FastMath.PI ) - edgeStart;
    final double arcRelativeEnd   = arcRelativeStart + arc.getSize();
    final double unwrappedEnd     = arcRelativeEnd - MathUtils.TWO_PI;
    final double tolerance = circle.getTolerance();
    Vertex previousVertex = start;
    if ( unwrappedEnd >= length - tolerance ) {
        insideList.add ( this );
    } else {
        double alreadyManagedLength = 0;
        if ( unwrappedEnd >= 0 ) {
            previousVertex = addSubEdge ( previousVertex,
                                          new Vertex ( new S2Point ( circle.getPointAt ( edgeStart + unwrappedEnd ) ) ),
                                          unwrappedEnd, insideList, splitCircle );
            alreadyManagedLength = unwrappedEnd;
        }
        if ( arcRelativeStart >= length - tolerance ) {
            if ( unwrappedEnd >= 0 ) {
                previousVertex = addSubEdge ( previousVertex, end,
                                              length - alreadyManagedLength, outsideList, splitCircle );
            } else {
                outsideList.add ( this );
            }
        } else {
            previousVertex = addSubEdge ( previousVertex,
                                          new Vertex ( new S2Point ( circle.getPointAt ( edgeStart + arcRelativeStart ) ) ),
                                          arcRelativeStart - alreadyManagedLength, outsideList, splitCircle );
            alreadyManagedLength = arcRelativeStart;
            if ( arcRelativeEnd >= length - tolerance ) {
                previousVertex = addSubEdge ( previousVertex, end,
                                              length - alreadyManagedLength, insideList, splitCircle );
            } else {
                previousVertex = addSubEdge ( previousVertex,
                                              new Vertex ( new S2Point ( circle.getPointAt ( edgeStart + arcRelativeStart ) ) ),
                                              arcRelativeStart - alreadyManagedLength, insideList, splitCircle );
                alreadyManagedLength = arcRelativeStart;
                previousVertex = addSubEdge ( previousVertex, end,
                                              length - alreadyManagedLength, outsideList, splitCircle );
            }
        }
    }
}
