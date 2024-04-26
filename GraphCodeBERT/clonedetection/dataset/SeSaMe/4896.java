public void draw ( Graphics2D g, int width, int height ) {
    g.setColor ( new Color ( data[0], data[1], data[2], data[3] ) );
    GeneralPath path = new GeneralPath();
    path.moveTo ( data[4] * width, data[5] * height );
    int polygonLength = ( data.length - 4 ) / 2;
    for ( int j = 1; j < polygonLength; j++ ) {
        path.lineTo ( data[4 + j * 2] * width, data[5 + j * 2] * height );
    }
    path.closePath();
    g.fill ( path );
}
