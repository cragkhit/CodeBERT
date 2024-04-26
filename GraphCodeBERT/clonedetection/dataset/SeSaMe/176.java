@Override
public int size() {
    int size = 0;
    for ( E e = first; e != null; e = getNext ( e ) ) {
        size++;
    }
    return size;
}
