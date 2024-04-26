Comment getComment ( int position ) {
    if ( this.comments == null ) {
        return null;
    }
    int size = this.comments.length;
    if ( size == 0 ) {
        return null;
    }
    int index = getCommentIndex ( 0, position, 0 );
    if ( index < 0 ) {
        return null;
    }
    return this.comments[index];
}
