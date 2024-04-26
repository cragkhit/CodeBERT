public int getFlatConfiguration ( FlatBufferBuilder builder ) {
    byte prof = profilingMode == OpExecutioner.ProfilingMode.INF_PANIC ? ProfilingMode.INF_PANIC :
                profilingMode == OpExecutioner.ProfilingMode.NAN_PANIC ? ProfilingMode.NAN_PANIC :
                profilingMode == OpExecutioner.ProfilingMode.ANY_PANIC ? ProfilingMode.ANY_PANIC : ProfilingMode.NONE;
    byte exec = executionMode == ExecutionMode.SEQUENTIAL ? org.nd4j.graph.ExecutionMode.SEQUENTIAL :
                executionMode == ExecutionMode.AUTO ? org.nd4j.graph.ExecutionMode.AUTO :
                executionMode == ExecutionMode.STRICT ? org.nd4j.graph.ExecutionMode.STRICT : -1;
    byte outp = outputMode == OutputMode.IMPLICIT ? org.nd4j.graph.OutputMode.IMPLICIT :
                outputMode == OutputMode.EXPLICIT ? org.nd4j.graph.OutputMode.EXPLICIT :
                outputMode == OutputMode.EXPLICIT_AND_IMPLICIT ? org.nd4j.graph.OutputMode.EXPLICIT_AND_IMPLICIT :
                outputMode == OutputMode.VARIABLE_SPACE ? org.nd4j.graph.OutputMode.VARIABLE_SPACE : -1;
    if ( exec == -1 ) {
        throw new UnsupportedOperationException ( "Unknown values were passed into configuration as ExecutionMode: [" + executionMode + "]" );
    }
    if ( outp == -1 ) {
        throw new UnsupportedOperationException ( "Unknown values were passed into configuration as OutputMode: [" + outputMode + "]" );
    }
    return FlatConfiguration.createFlatConfiguration ( builder, -1, prof, exec, outp, gatherTimings, footprintForward, footprintBackward, Direction.FORWARD_ONLY );
}
