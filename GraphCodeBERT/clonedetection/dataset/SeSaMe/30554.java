public synchronized Set<Service> getServices() {
    checkInitialized();
    if ( legacyChanged || servicesChanged ) {
        serviceSet = null;
    }
    if ( serviceSet == null ) {
        ensureLegacyParsed();
        Set<Service> set = new LinkedHashSet<>();
        if ( serviceMap != null ) {
            set.addAll ( serviceMap.values() );
        }
        if ( legacyMap != null ) {
            set.addAll ( legacyMap.values() );
        }
        serviceSet = Collections.unmodifiableSet ( set );
        servicesChanged = false;
    }
    return serviceSet;
}
