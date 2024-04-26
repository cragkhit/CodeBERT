public int[] getArrayOfIntValues() {
    byte[] bufArray = ( byte[] ) myValue;
    if ( bufArray != null ) {
        ByteArrayInputStream bufStream =
            new ByteArrayInputStream ( bufArray );
        int available = bufStream.available();
        bufStream.mark ( available );
        bufStream.skip ( available - 1 );
        int length = bufStream.read();
        bufStream.reset();
        int[] valueArray = new int[length];
        for ( int i = 0; i < length; i++ ) {
            int valLength = bufStream.read();
            if ( valLength != 4 ) {
                return null;
            }
            byte[] bufBytes = new byte[valLength];
            bufStream.read ( bufBytes, 0, valLength );
            valueArray[i] = convertToInt ( bufBytes );
        }
        return valueArray;
    }
    return null;
}
