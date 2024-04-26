public ModuleMode getModuleMode() {
    switch ( accessFilter.getAccessValue ( ElementKind.MODULE ) ) {
    case PACKAGE:
    case PRIVATE:
        return DocletEnvironment.ModuleMode.ALL;
    default:
        return DocletEnvironment.ModuleMode.API;
    }
}
