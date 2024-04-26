public Cartesian3D closestPoint ( final Line line ) {
    final double cos = direction.dotProduct ( line.direction );
    final double n = 1 - cos * cos;
    if ( n < Precision.EPSILON ) {
        return zero;
    }
    final Cartesian3D delta0 = line.zero.subtract ( zero );
    final double a        = delta0.dotProduct ( direction );
    final double b        = delta0.dotProduct ( line.direction );
    return new Cartesian3D ( 1, zero, ( a - b * cos ) / n, direction );
}
