protected char[] getTypeContents() {
    if ( isTypeAltered() ) {
        return this.fType.toCharArray();
    } else {
        return CharOperation.subarray ( this.fDocument, this.fTypeRange[0], this.fTypeRange[1] + 1 );
    }
}
