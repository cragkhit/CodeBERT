public static TraditionalBinaryPrefix valueOf ( char symbol ) {
    symbol = Character.toUpperCase ( symbol );
    for ( TraditionalBinaryPrefix prefix : TraditionalBinaryPrefix.values() ) {
        if ( symbol == prefix.symbol ) {
            return prefix;
        }
    }
    throw new IllegalArgumentException ( "Unknown symbol '" + symbol + "'" );
}
