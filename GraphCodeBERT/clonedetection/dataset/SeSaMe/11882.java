public void generateCodeAttributeHeader() {
    if ( this.contentsOffset + 20 >= this.contents.length ) {
        resizeContents ( 20 );
    }
    int constantValueNameIndex =
        this.constantPool.literalIndex ( AttributeNamesConstants.CodeName );
    this.contents[this.contentsOffset++] = ( byte ) ( constantValueNameIndex >> 8 );
    this.contents[this.contentsOffset++] = ( byte ) constantValueNameIndex;
    this.contentsOffset += 12;
}
