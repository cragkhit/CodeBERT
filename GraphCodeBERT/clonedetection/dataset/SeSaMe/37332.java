@SuppressWarnings ( "try" )
public void run() {
    HotSpotJVMCIRuntime.runtime();
    AOTCompiler.logCompilation ( JavaMethodInfo.uniqueMethodName ( method ), "Compiling" );
    final long threadId = Thread.currentThread().getId();
    final boolean printCompilation = GraalCompilerOptions.PrintCompilation.getValue ( graalOptions ) && !TTY.isSuppressed() && GraalServices.isThreadAllocatedMemorySupported();
    if ( printCompilation ) {
        TTY.println ( getMethodDescription() + "..." );
    }
    final long start;
    final long allocatedBytesBefore;
    if ( printCompilation ) {
        start = System.currentTimeMillis();
        allocatedBytesBefore = GraalServices.getThreadAllocatedBytes ( threadId );
    } else {
        start = 0L;
        allocatedBytesBefore = 0L;
    }
    CompilationResult compResult = null;
    final long startTime = System.currentTimeMillis();
    SnippetReflectionProvider snippetReflection = aotBackend.getProviders().getSnippetReflection();
    try ( DebugContext debug = DebugContext.create ( graalOptions, new GraalDebugHandlersFactory ( snippetReflection ) ); Activation a = debug.activate() ) {
        compResult = aotBackend.compileMethod ( method, debug );
    }
    final long endTime = System.currentTimeMillis();
    if ( printCompilation ) {
        final long stop = System.currentTimeMillis();
        final int targetCodeSize = compResult != null ? compResult.getTargetCodeSize() : -1;
        final long allocatedBytesAfter = GraalServices.getThreadAllocatedBytes ( threadId );
        final long allocatedBytes = ( allocatedBytesAfter - allocatedBytesBefore ) / 1024;
        TTY.println ( getMethodDescription() + String.format ( " | %4dms %5dB %5dkB", stop - start, targetCodeSize, allocatedBytes ) );
    }
    if ( compResult == null ) {
        result = null;
        return;
    }
    LogPrinter.writeLog ( "    Compile Time: " + TimeUnit.MILLISECONDS.toSeconds ( endTime - startTime ) + "secs" );
    if ( main.options.debug ) {
        aotBackend.printCompiledMethod ( ( HotSpotResolvedJavaMethod ) method, compResult );
    }
    result = new CompiledMethodInfo ( compResult, new AOTHotSpotResolvedJavaMethod ( ( HotSpotResolvedJavaMethod ) method, aotBackend.getBackend() ) );
}
