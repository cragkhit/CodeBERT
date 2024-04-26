public Map<String, MapModule> getMapModules() {
    HashMap<String, MapModule> returnValue = new HashMap<>();
    for ( MapModule module : mapModuleVector ) {
        returnValue.put ( module.getDisplayName(), module );
    }
    return Collections.unmodifiableMap ( returnValue );
}
