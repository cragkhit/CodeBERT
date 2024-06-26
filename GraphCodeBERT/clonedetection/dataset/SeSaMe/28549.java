public boolean contains ( Object o ) {
    if ( o == null ) {
        return false;
    }
    fullyLock();
    try {
        for ( Node<E> p = head.next; p != null; p = p.next )
            if ( o.equals ( p.item ) ) {
                return true;
            }
        return false;
    } finally {
        fullyUnlock();
    }
}
