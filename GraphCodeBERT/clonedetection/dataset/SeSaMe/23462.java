public long initTimeout ( String name, long newValue ) {
    long result = getTimeout ( name );
    if ( !contains ( name ) ) {
        setTimeout ( name, newValue );
    }
    return result;
}
