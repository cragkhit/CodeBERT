public void addPrefixAlias ( String prefix, String alias ) {
    if ( _aliases == null ) {
        _aliases = new HashMap<>();
    }
    _aliases.put ( prefix, alias );
}
