public List<String> getMapKeys() {
    LinkedList<String> returnValue = new LinkedList<>();
    for ( MapModule module : mapModuleVector ) {
        returnValue.add ( module.getDisplayName() );
    }
    return Collections.unmodifiableList ( returnValue );
}
