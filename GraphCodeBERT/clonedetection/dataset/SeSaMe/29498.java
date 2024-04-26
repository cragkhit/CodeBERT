public void setComment ( String comment ) {
    if ( comment != null ) {
        this.comment = zc.getBytes ( comment );
        if ( this.comment.length > 0xffff ) {
            throw new IllegalArgumentException ( "ZIP file comment too long." );
        }
    }
}
