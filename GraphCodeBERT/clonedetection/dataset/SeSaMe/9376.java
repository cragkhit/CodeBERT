public Pair<Cluster, Double> nearestCluster ( Point point ) {
    Cluster nearestCluster = null;
    double minDistance = isInverse() ? Float.MIN_VALUE : Float.MAX_VALUE;
    double currentDistance;
    for ( Cluster cluster : getClusters() ) {
        currentDistance = cluster.getDistanceToCenter ( point );
        if ( isInverse() ) {
            if ( currentDistance > minDistance ) {
                minDistance = currentDistance;
                nearestCluster = cluster;
            }
        } else {
            if ( currentDistance < minDistance ) {
                minDistance = currentDistance;
                nearestCluster = cluster;
            }
        }
    }
    return Pair.of ( nearestCluster, minDistance );
}
