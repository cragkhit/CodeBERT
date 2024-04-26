public IJavaElement[] getElements() {
    int elementLength = this.elementIndex + 1;
    if ( this.elements.length != elementLength ) {
        System.arraycopy ( this.elements, 0, this.elements = new IJavaElement[elementLength], 0, elementLength );
    }
    return this.elements;
}
