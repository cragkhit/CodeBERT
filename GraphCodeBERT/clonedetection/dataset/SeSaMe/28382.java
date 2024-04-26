@SuppressWarnings ( "unchecked" )
public synchronized V get ( Object key ) {
    Entry<?, ?> tab[] = table;
    int hash = key.hashCode();
    int index = ( hash & 0x7FFFFFFF ) % tab.length;
    for ( Entry<?, ?> e = tab[index] ; e != null ; e = e.next ) {
        if ( ( e.hash == hash ) && e.key.equals ( key ) ) {
            return ( V ) e.value;
        }
    }
    return null;
}
