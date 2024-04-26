public MBeanInstantiator getMBeanInstantiator() {
    if ( interceptorsEnabled ) {
        return instantiator;
    } else throw new UnsupportedOperationException (
            "MBeanServerInterceptors are disabled." );
}
