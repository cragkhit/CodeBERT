public void addObject ( T object ) {
    if ( object == null ) {
        containsNull = true;
        return;
    }
    Entry<T> entry = map.get ( object );
    if ( entry == null ) {
        entry = new Entry<> ( object );
        map.put ( object, entry );
    }
    entry.frequency++;
}
