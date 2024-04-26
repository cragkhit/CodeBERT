protected void rehash ( int newCapacity ) {
    int oldCapacity = keys.length;
    String oldKeys[] = keys;
    NameSpaceSymbEntry oldVals[] = entries;
    keys = new String[newCapacity];
    entries = new NameSpaceSymbEntry[newCapacity];
    for ( int i = oldCapacity; i-- > 0; ) {
        if ( oldKeys[i] != null ) {
            String o = oldKeys[i];
            int index = index ( o );
            keys[index] = o;
            entries[index] = oldVals[i];
        }
    }
}
