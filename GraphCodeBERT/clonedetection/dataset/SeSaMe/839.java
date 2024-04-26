public String getMessage() {
    String message = getCustomMessage();
    if ( message == null ) {
        try {
            final ResourceBundle resourceBundle = getBundle ( bundle );
            final String pattern = resourceBundle.getString ( key );
            final MessageFormat formatter = new MessageFormat ( pattern, Locale.ROOT );
            message = formatter.format ( args );
        } catch ( final MissingResourceException ignored ) {
            final MessageFormat formatter = new MessageFormat ( key, Locale.ROOT );
            message = formatter.format ( args );
        }
    }
    return message;
}
