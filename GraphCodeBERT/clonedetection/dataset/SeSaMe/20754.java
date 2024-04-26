public void baselineMemoryAllocation() {
    ThreadMXBean bean = ( ThreadMXBean ) ManagementFactory.getThreadMXBean();
    threadIds = bean.getAllThreadIds();
    baselinedThreadMemoryUsage = bean.getThreadAllocatedBytes ( threadIds );
}
