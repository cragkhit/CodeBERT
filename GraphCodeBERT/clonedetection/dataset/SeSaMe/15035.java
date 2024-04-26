protected static Color getAntiColor2 ( Color c ) {
    float[] hsb = Color.RGBtoHSB ( c.getRed(), c.getGreen(), c.getBlue(),
                                   null );
    hsb[0] -= 0.40;
    if ( hsb[0] < 0 ) {
        hsb[0]++;
    }
    hsb[1] = 1;
    hsb[2] = ( float ) 0.8;
    return Color.getHSBColor ( hsb[0], hsb[1], hsb[2] );
}
