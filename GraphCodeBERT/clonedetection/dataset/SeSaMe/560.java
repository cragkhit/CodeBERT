public int getIndexOfChild ( Object parent, Object child ) {
    int index = -1;
    for ( int i = 0; i < getChildCount ( parent ); i++ ) {
        if ( getChild ( parent, i ).equals ( child ) ) {
            index = i;
            break;
        }
    }
    return index;
}
