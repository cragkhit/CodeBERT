public static void initializeMessages ( Class<?> clazz, String rbName ) {
    ResourceBundle rb = null;
    try {
        rb = ResourceBundle.getBundle ( rbName );
    } catch ( MissingResourceException mre ) {
    }
    for ( Field field : clazz.getFields() ) {
        if ( isWritableField ( field ) ) {
            String key = field.getName();
            String message = getMessage ( rb, key );
            int mnemonicInt = findMnemonicInt ( message );
            message = removeMnemonicAmpersand ( message );
            message = replaceWithPlatformLineFeed ( message );
            setFieldValue ( field, message );
            MNEMONIC_LOOKUP.put ( message, mnemonicInt );
        }
    }
}
