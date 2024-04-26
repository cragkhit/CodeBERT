public boolean contains ( Object o ) {
    if ( o == null ) {
        return false;
    }
    restartFromHead: for ( ;; ) {
        for ( Node p = head, pred = null; p != null; ) {
            Node q = p.next;
            final Object item;
            if ( ( item = p.item ) != null ) {
                if ( p.isData ) {
                    if ( o.equals ( item ) ) {
                        return true;
                    }
                    pred = p;
                    p = q;
                    continue;
                }
            } else if ( !p.isData ) {
                break;
            }
            for ( Node c = p;; q = p.next ) {
                if ( q == null || !q.isMatched() ) {
                    pred = skipDeadNodes ( pred, c, p, q );
                    p = q;
                    break;
                }
                if ( p == ( p = q ) ) {
                    continue restartFromHead;
                }
            }
        }
        return false;
    }
}
