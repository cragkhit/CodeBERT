@SuppressWarnings ( {"unchecked"} )
public T removeFirst() {
    T o = _head;
    if ( o == null ) {
        return null;
    }
    T n = o.getNext();
    o.setNext ( null );
    if ( null != n ) {
        n.setPrevious ( null );
    }
    _head = n;
    if ( --_size == 0 ) {
        _tail = null;
    }
    return o;
}
