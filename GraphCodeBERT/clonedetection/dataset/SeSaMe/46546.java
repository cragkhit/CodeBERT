public static int getSizeOfType ( int dataType ) {
    if ( dataType < MIN_DATATYPE || dataType > MAX_DATATYPE ) {
        throw new IllegalArgumentException ( "dataType out of range!" );
    }
    return SIZE_OF_TYPE[dataType];
}
