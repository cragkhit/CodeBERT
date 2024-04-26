protected void addModulesToIndexMap() {
    for ( ModuleElement mdle : configuration.modules ) {
        String mdleName = mdle.getQualifiedName().toString();
        char ch = ( mdleName.length() == 0 )
                  ? '*'
                  : Character.toUpperCase ( mdleName.charAt ( 0 ) );
        Character unicode = ch;
        SortedSet<Element> list = indexmap.computeIfAbsent ( unicode,
                                  c -> new TreeSet<> ( comparator ) );
        list.add ( mdle );
    }
}
