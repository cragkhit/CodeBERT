public boolean getBoolProperty ( String key ) {
    String boolProperty = getProperty ( key );
    return Tools.safeEquals ( "true", boolProperty );
}
