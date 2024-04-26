@Override
public void addElement ( final double value ) {
    if ( internalArray.length <= startIndex + numElements ) {
        expand();
    }
    internalArray[startIndex + numElements++] = value;
}
