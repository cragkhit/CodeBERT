public IntegerArray getDOMNodeById ( String id ) {
    IntegerArray nodes = null;
    if ( _enhancedDOM != null ) {
        int ident = _enhancedDOM.getElementById ( id );
        if ( ident != DTM.NULL ) {
            Integer root = _enhancedDOM.getDocument();
            Map<String, IntegerArray> index = _rootToIndexMap.get ( root );
            if ( index == null ) {
                index = new HashMap<>();
                _rootToIndexMap.put ( root, index );
            } else {
                nodes = index.get ( id );
            }
            if ( nodes == null ) {
                nodes = new IntegerArray();
                index.put ( id, nodes );
            }
            nodes.add ( _enhancedDOM.getNodeHandle ( ident ) );
        }
    }
    return nodes;
}
