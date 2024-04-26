public static String getMajorVersion() {
    return ( extractValue ( getProperties().getClass().
                            getClassLoader().getResourceAsStream ( "org/netbeans/jemmy/version_info" ),
                            "Jemmy-MajorVersion" ) );
}
