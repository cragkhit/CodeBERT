public List<String> handleOptions ( T task, String[] args ) throws BadArgs {
    command = Arrays.copyOf ( args, args.length );
    pluginOptions = new PluginsHelper ( null );
    for ( int i = 0; i < args.length; i++ ) {
        if ( args[i].startsWith ( "-" ) ) {
            String name = args[i];
            PluginOption pluginOption = null;
            Option<T> option = getOption ( name );
            if ( option == null ) {
                pluginOption = pluginOptions.getOption ( name );
                if ( pluginOption == null ) {
                    throw new BadArgs ( "err.unknown.option", name ).
                    showUsage ( true );
                }
            }
            Option<?> opt = pluginOption == null ? option : pluginOption;
            String param = null;
            if ( opt.hasArg ) {
                if ( name.startsWith ( "--" ) && name.indexOf ( '=' ) > 0 ) {
                    param = name.substring ( name.indexOf ( '=' ) + 1,
                                             name.length() );
                } else if ( i + 1 < args.length ) {
                    param = args[++i];
                }
                if ( param == null || param.isEmpty()
                        || ( param.length() >= 2 && param.charAt ( 0 ) == '-'
                             && param.charAt ( 1 ) == '-' ) ) {
                    throw new BadArgs ( "err.missing.arg", name ).
                    showUsage ( true );
                }
            }
            if ( pluginOption != null ) {
                pluginOption.process ( pluginOptions, name, param );
            } else {
                option.process ( task, name, param );
                if ( option.isTerminal() ) {
                    return ++i < args.length
                           ? Stream.of ( Arrays.copyOfRange ( args, i, args.length ) )
                           .collect ( Collectors.toList() )
                           : Collections.emptyList();
                }
            }
            if ( opt.ignoreRest() ) {
                i = args.length;
            }
        } else {
            return Stream.of ( Arrays.copyOfRange ( args, i, args.length ) )
                   .collect ( Collectors.toList() );
        }
    }
    return Collections.emptyList();
}
