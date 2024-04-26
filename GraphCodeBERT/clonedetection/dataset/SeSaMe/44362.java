@SuppressWarnings ( "deprecation" )
protected float getPreTab ( float x, int tabOffset ) {
    Document d = getDocument();
    View v = getViewAtPosition ( tabOffset, null );
    if ( ( d instanceof StyledDocument ) && v != null ) {
        Font f = ( ( StyledDocument ) d ).getFont ( v.getAttributes() );
        Container c = getContainer();
        FontMetrics fm = ( c != null ) ? c.getFontMetrics ( f ) :
                         Toolkit.getDefaultToolkit().getFontMetrics ( f );
        int width = getCharactersPerTab() * fm.charWidth ( 'W' );
        int tb = ( int ) getTabBase();
        return ( float ) ( ( ( ( int ) x - tb ) / width + 1 ) * width + tb );
    }
    return 10.0f + x;
}
