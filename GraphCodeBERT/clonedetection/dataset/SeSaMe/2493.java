static boolean isPackageAccess ( final int modifiers ) {
    return ( modifiers & ACCESS_TEST ) == 0;
}
