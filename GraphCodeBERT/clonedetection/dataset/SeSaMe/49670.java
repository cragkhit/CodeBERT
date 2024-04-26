protected int hash ( Object key ) {
    if ( fHashMultipliers == null || ! ( key instanceof String ) ) {
        return key.hashCode() & 0x7FFFFFFF;
    }
    return hash0 ( ( String ) key );
} 
