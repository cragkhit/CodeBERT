@Override
public INDArray getColumn ( long c ) {
    Nd4j.getCompressor().autoDecompress ( this );
    if ( isColumnVector() && c == 0 ) {
        return this;
    } else if ( isColumnVector() && c > 0 ) {
        throw new IllegalArgumentException ( "Illegal index for row" );
    } else if ( isRowVector() ) {
        return Nd4j.scalar ( getDouble ( c ) );
    }
    return get ( NDArrayIndex.all(), NDArrayIndex.point ( c ) );
}
