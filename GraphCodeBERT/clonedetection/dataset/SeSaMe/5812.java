public int getCurrentDeviceArchitecture() {
    int deviceId = Nd4j.getAffinityManager().getDeviceForCurrentThread();
    if ( !arch.containsKey ( deviceId ) ) {
        int major = NativeOpsHolder.getInstance().getDeviceNativeOps().getDeviceMajor ( new CudaPointer ( deviceId ) );
        int minor = NativeOpsHolder.getInstance().getDeviceNativeOps().getDeviceMinor ( new CudaPointer ( deviceId ) );
        Integer cc = Integer.parseInt ( new String ( "" + major + minor ) );
        arch.put ( deviceId, cc );
        return cc;
    }
    return arch.get ( deviceId );
}
