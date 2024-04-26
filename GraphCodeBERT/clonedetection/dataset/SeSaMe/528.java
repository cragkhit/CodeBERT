protected static List<Configuration> getModuleConfigs ( String moduleName ) {
    final List<Configuration> result = new ArrayList<>();
    for ( Configuration currentConfig : CONFIGURATION.getChildren() ) {
        if ( "TreeWalker".equals ( currentConfig.getName() ) ) {
            for ( Configuration moduleConfig : currentConfig.getChildren() ) {
                if ( moduleName.equals ( moduleConfig.getName() ) ) {
                    result.add ( moduleConfig );
                }
            }
        } else if ( moduleName.equals ( currentConfig.getName() ) ) {
            result.add ( currentConfig );
        }
    }
    return result;
}
