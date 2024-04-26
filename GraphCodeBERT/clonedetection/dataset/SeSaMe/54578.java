static ResourceBundle loadResourceBundle ( String bundleName ) {
    Class<?> c = Class.forName ( LocaleDataProvider.class.getModule(), bundleName );
    if ( c != null && ResourceBundle.class.isAssignableFrom ( c ) ) {
        try {
            @SuppressWarnings ( {"unchecked", "deprecation"} )
            ResourceBundle rb = ( ( Class<ResourceBundle> ) c ).newInstance();
            return rb;
        } catch ( InstantiationException | IllegalAccessException e ) {
            throw new InternalError ( e );
        }
    }
    return null;
}
