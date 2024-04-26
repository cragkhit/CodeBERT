public static LocaleProviderAdapter forType ( Type type ) {
    switch ( type ) {
    case JRE:
    case CLDR:
    case SPI:
    case HOST:
    case FALLBACK:
        LocaleProviderAdapter adapter = null;
        LocaleProviderAdapter cached = adapterInstances.get ( type );
        if ( cached == null ) {
            try {
                @SuppressWarnings ( "deprecation" )
                Object tmp = Class.forName ( type.getAdapterClassName() ).newInstance();
                adapter = ( LocaleProviderAdapter ) tmp;
                cached = adapterInstances.putIfAbsent ( type, adapter );
                if ( cached != null ) {
                    adapter = cached;
                }
            } catch ( ClassNotFoundException |
                          IllegalAccessException |
                          InstantiationException |
                          UnsupportedOperationException e ) {
                LocaleServiceProviderPool.config ( LocaleProviderAdapter.class, e.toString() );
                adapterInstances.putIfAbsent ( type, NONEXISTENT_ADAPTER );
                if ( defaultLocaleProviderAdapter == type ) {
                    defaultLocaleProviderAdapter = Type.FALLBACK;
                }
            }
        } else if ( cached != NONEXISTENT_ADAPTER ) {
            adapter = cached;
        }
        return adapter;
    default:
        throw new InternalError ( "unknown locale data adapter type" );
    }
}
