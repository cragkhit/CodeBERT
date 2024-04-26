public static SphericalPolygonsSet parseSphericalPolygonsSet ( final String s )
throws IOException, ParseException {
    final TreeBuilder<Sphere2D> builder = new TreeBuilder<Sphere2D> ( "SphericalPolygonsSet", s ) {
        @Override
        public Circle parseHyperplane()
        throws IOException, ParseException {
            return new Circle ( new Cartesian3D ( getNumber(), getNumber(), getNumber() ), getNumber() );
        }
    };
    return new SphericalPolygonsSet ( builder.getTree(), builder.getTolerance() );
}
