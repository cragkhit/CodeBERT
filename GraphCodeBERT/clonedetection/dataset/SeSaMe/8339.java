public void setLabels ( INDArray... labels ) {
    if ( labels != null && labels.length != this.numOutputArrays ) {
        throw new IllegalArgumentException ( "Invalid output array: network has " + numOutputArrays
                                             + " outputs, but array is of length " + labels.length );
    }
    this.labels = labels;
}
