static String getDefaultLocalizedString ( String key, Object... args ) {
    return getLocalizedString ( List.of ( getDefaultBundle() ), key, args );
}
