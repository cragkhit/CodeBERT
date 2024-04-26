public int size() {
    restartFromHead: for ( ;; ) {
        int count = 0;
        for ( Node<E> p = first(); p != null; ) {
            if ( p.item != null )
                if ( ++count == Integer.MAX_VALUE ) {
                    break;    
                }
            if ( p == ( p = p.next ) ) {
                continue restartFromHead;
            }
        }
        return count;
    }
}
