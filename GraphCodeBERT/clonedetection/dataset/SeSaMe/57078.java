public boolean addMapping ( String prefix, String uri, Attr n ) {
    NameSpaceSymbEntry ob = symb.get ( prefix );
    if ( ob != null && uri.equals ( ob.uri ) ) {
        return false;
    }
    NameSpaceSymbEntry ne = new NameSpaceSymbEntry ( uri, n, false, prefix );
    needsClone();
    symb.put ( prefix, ne );
    if ( ob != null ) {
        ne.lastrendered = ob.lastrendered;
        if ( ob.lastrendered != null && ob.lastrendered.equals ( uri ) ) {
            ne.rendered = true;
        }
    }
    return true;
}
