public Position createPosition ( int offset ) throws BadLocationException {
    while ( queue.poll() != null ) {
        unusedMarks++;
    }
    if ( unusedMarks > Math.max ( 5, ( marks.size() / 10 ) ) ) {
        removeUnusedMarks();
    }
    int g0 = getGapStart();
    int g1 = getGapEnd();
    int index = ( offset < g0 ) ? offset : offset + ( g1 - g0 );
    search.index = index;
    int sortIndex = findSortIndex ( search );
    MarkData m;
    StickyPosition position;
    if ( sortIndex < marks.size()
            && ( m = marks.elementAt ( sortIndex ) ).index == index
            && ( position = m.getPosition() ) != null ) {
    } else {
        position = new StickyPosition();
        m = new MarkData ( index, position, queue );
        position.setMark ( m );
        marks.insertElementAt ( m, sortIndex );
    }
    return position;
}
