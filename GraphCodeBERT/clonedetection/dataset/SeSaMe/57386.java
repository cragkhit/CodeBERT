public Object getAttribute ( String attribute )
throws AttributeNotFoundException,
    MBeanException, ReflectionException {
    try {
        if ( attribute == null ) {
            throw new AttributeNotFoundException ( "null" );
        }
        if ( attribute.equals ( "MBeanServerId" ) ) {
            return getMBeanServerId();
        } else if ( attribute.equals ( "SpecificationName" ) ) {
            return getSpecificationName();
        } else if ( attribute.equals ( "SpecificationVersion" ) ) {
            return getSpecificationVersion();
        } else if ( attribute.equals ( "SpecificationVendor" ) ) {
            return getSpecificationVendor();
        } else if ( attribute.equals ( "ImplementationName" ) ) {
            return getImplementationName();
        } else if ( attribute.equals ( "ImplementationVersion" ) ) {
            return getImplementationVersion();
        } else if ( attribute.equals ( "ImplementationVendor" ) ) {
            return getImplementationVendor();
        }
        else {
            throw new AttributeNotFoundException ( "null" );
        }
    } catch ( AttributeNotFoundException x ) {
        throw x;
    } catch ( JMRuntimeException j ) {
        throw j;
    } catch ( SecurityException s ) {
        throw s;
    } catch ( Exception x ) {
        throw new MBeanException ( x, "Failed to get " + attribute );
    }
}
