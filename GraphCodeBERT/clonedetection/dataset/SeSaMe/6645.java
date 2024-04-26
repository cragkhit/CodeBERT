@Override
public long getMemoryFootprint() {
    long reqMem = 0;
    for ( INDArray f : features ) {
        reqMem += f == null ? 0 : f.lengthLong() * Nd4j.sizeOfDataType();
    }
    if ( featuresMaskArrays != null )
        for ( INDArray f : featuresMaskArrays ) {
            reqMem += f == null ? 0 : f.lengthLong() * Nd4j.sizeOfDataType();
        }
    if ( labelsMaskArrays != null )
        for ( INDArray f : labelsMaskArrays ) {
            reqMem += f == null ? 0 : f.lengthLong() * Nd4j.sizeOfDataType();
        }
    if ( labels != null )
        for ( INDArray f : labels ) {
            reqMem += f == null ? 0 : f.lengthLong() * Nd4j.sizeOfDataType();
        }
    return reqMem;
}
