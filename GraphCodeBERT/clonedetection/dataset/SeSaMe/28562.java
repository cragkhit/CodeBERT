public boolean contains ( Object o ) {
    if ( o == null ) {
        return false;
    }
    restartFromHead: for ( ;; ) {
        for ( Node<E> p = head, pred = null; p != null; ) {
            Node<E> q = p.next;
            final E item;
            if ( ( item = p.item ) != null ) {
                if ( o.equals ( item ) ) {
                    return true;
                }
                pred = p;
                p = q;
                continue;
            }
            for ( Node<E> c = p;; q = p.next ) {
                if ( q == null || q.item != null ) {
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
