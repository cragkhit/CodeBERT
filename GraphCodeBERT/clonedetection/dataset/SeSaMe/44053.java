public ContentModel getModel() {
    ContentModel m = model;
    for ( int i = 0; i < value; i++ ) {
        if ( m.next != null ) {
            m = m.next;
        } else {
            return null;
        }
    }
    return m;
}
