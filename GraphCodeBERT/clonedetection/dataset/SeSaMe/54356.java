public void setSkeleton ( Remote impl ) throws RemoteException {
    if ( !withoutSkeletons.containsKey ( impl.getClass() ) ) {
        try {
            skel = Util.createSkeleton ( impl );
        } catch ( SkeletonNotFoundException e ) {
            withoutSkeletons.put ( impl.getClass(), null );
        }
    }
}
