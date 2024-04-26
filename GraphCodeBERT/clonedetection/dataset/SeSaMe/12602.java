public void setSourceNameOverride ( char[] sourceName ) {
    char[] oldSourceName = getSourceName();
    if ( !CharArrayUtils.equals ( oldSourceName, sourceName ) ) {
        INNER_CLASS_SOURCE_NAME.put ( getNd(), this.address, sourceName );
    }
}
