public void addPattern ( String pattern ) throws ParseException {
    if ( pattern == null ) {
        return;
    }
    PatternEntry.Parser parser = new PatternEntry.Parser ( pattern );
    PatternEntry entry = parser.next();
    while ( entry != null ) {
        fixEntry ( entry );
        entry = parser.next();
    }
}
