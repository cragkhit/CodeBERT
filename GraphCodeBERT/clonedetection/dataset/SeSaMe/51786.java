public int getNodeByPosition ( int position ) {
    int node = DTMAxisIterator.END;
    if ( _nodes != null ) {
        if ( position > 0 ) {
            if ( position <= _nodes.cardinality() ) {
                _position = position;
                node = _nodes.at ( position - 1 );
            } else {
                _position = _nodes.cardinality();
            }
        }
    } else {
        node = super.getNodeByPosition ( position );
    }
    return node;
}
