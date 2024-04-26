static Color stringToColor ( String str ) {
    Color color;
    if ( str == null ) {
        return null;
    }
    if ( str.length() == 0 ) {
        color = Color.black;
    } else if ( str.startsWith ( "rgb(" ) ) {
        color = parseRGB ( str );
    } else if ( str.charAt ( 0 ) == '#' ) {
        color = hexToColor ( str );
    } else if ( str.equalsIgnoreCase ( "Black" ) ) {
        color = hexToColor ( "#000000" );
    } else if ( str.equalsIgnoreCase ( "Silver" ) ) {
        color = hexToColor ( "#C0C0C0" );
    } else if ( str.equalsIgnoreCase ( "Gray" ) ) {
        color = hexToColor ( "#808080" );
    } else if ( str.equalsIgnoreCase ( "White" ) ) {
        color = hexToColor ( "#FFFFFF" );
    } else if ( str.equalsIgnoreCase ( "Maroon" ) ) {
        color = hexToColor ( "#800000" );
    } else if ( str.equalsIgnoreCase ( "Red" ) ) {
        color = hexToColor ( "#FF0000" );
    } else if ( str.equalsIgnoreCase ( "Purple" ) ) {
        color = hexToColor ( "#800080" );
    } else if ( str.equalsIgnoreCase ( "Fuchsia" ) ) {
        color = hexToColor ( "#FF00FF" );
    } else if ( str.equalsIgnoreCase ( "Green" ) ) {
        color = hexToColor ( "#008000" );
    } else if ( str.equalsIgnoreCase ( "Lime" ) ) {
        color = hexToColor ( "#00FF00" );
    } else if ( str.equalsIgnoreCase ( "Olive" ) ) {
        color = hexToColor ( "#808000" );
    } else if ( str.equalsIgnoreCase ( "Yellow" ) ) {
        color = hexToColor ( "#FFFF00" );
    } else if ( str.equalsIgnoreCase ( "Navy" ) ) {
        color = hexToColor ( "#000080" );
    } else if ( str.equalsIgnoreCase ( "Blue" ) ) {
        color = hexToColor ( "#0000FF" );
    } else if ( str.equalsIgnoreCase ( "Teal" ) ) {
        color = hexToColor ( "#008080" );
    } else if ( str.equalsIgnoreCase ( "Aqua" ) ) {
        color = hexToColor ( "#00FFFF" );
    } else if ( str.equalsIgnoreCase ( "Orange" ) ) {
        color = hexToColor ( "#FF8000" );
    } else {
        color = hexToColor ( str );    
    }
    return color;
}
