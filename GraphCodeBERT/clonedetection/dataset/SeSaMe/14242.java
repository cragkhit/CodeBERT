protected void appendContentsOfChildren ( CharArrayBuffer buffer ) {
    DOMNode child = this.fFirstChild;
    DOMNode sibling;
    int start = 0, end = 0;
    if ( child != null ) {
        start = child.getStartPosition();
        end = child.getEndPosition();
    }
    while ( child != null ) {
        sibling = child.fNextNode;
        if ( sibling != null ) {
            if ( sibling.isContentMergableWith ( child ) ) {
                end = sibling.getEndPosition();
            } else {
                if ( child.isFragmented() ) {
                    child.appendContents ( buffer );
                } else {
                    buffer.append ( child.getDocument(), start, end + 1 - start );
                }
                start = sibling.getStartPosition();
                end = sibling.getEndPosition();
            }
        } else {
            if ( child.isFragmented() ) {
                child.appendContents ( buffer );
            } else {
                buffer.append ( child.getDocument(), start, end + 1 - start );
            }
        }
        child = sibling;
    }
}
