@Override
public DataBuffer getVectorCoordinates() {
    int idx;
    if ( isRowVector() ) {
        idx = 1;
    } else if ( isColumnVector() ) {
        idx = 0;
    } else {
        throw new UnsupportedOperationException();
    }
    int[] temp = new int[ ( int ) length()];
    for ( int i = 0; i < length(); i++ ) {
        temp[i] = getUnderlyingIndicesOf ( i ).getInt ( idx );
    }
    return Nd4j.createBuffer ( temp );
}
