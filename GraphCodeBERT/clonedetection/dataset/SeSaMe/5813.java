@Override
public void init ( @NonNull Configuration configuration, @NonNull Allocator allocator ) {
    this.configuration = configuration;
    this.deviceMemoryTracker = new DeviceAllocationsTracker ( this.configuration );
    this.flowController.init ( allocator );
}
