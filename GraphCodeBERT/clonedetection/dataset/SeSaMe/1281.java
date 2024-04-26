@Override
public V setValue ( final V value ) {
    if ( value == this ) {
        throw new IllegalArgumentException ( "DefaultKeyValue may not contain itself as a value." );
    }
    return super.setValue ( value );
}
