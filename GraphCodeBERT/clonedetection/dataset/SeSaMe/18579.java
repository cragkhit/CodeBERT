@Deprecated
public void trimToSize() {
    for ( Collection<V> collection : backingMap().values() ) {
        ArrayList<V> arrayList = ( ArrayList<V> ) collection;
        arrayList.trimToSize();
    }
}
