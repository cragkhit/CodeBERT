public byte getSuspendPolicy() {
    try {
        return getByte ( SuspendPolicyOffset );
    } catch ( BoundException e ) {
        throw new Failure ( "Caught unexpected exception while getting event kind from header:\n\t"
                            + e );
    }
}
