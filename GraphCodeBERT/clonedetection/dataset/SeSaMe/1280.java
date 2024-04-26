@Override
public K setKey ( final K key ) {
    if ( key == this ) {
        throw new IllegalArgumentException ( "DefaultKeyValue may not contain itself as a key." );
    }
    return super.setKey ( key );
}
