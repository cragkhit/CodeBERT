@Override
public void iterationDone ( Model model, int iteration, int epoch ) {
    if ( invocationType == InvocationType.ITERATION_END ) {
        invokeListener ( model );
    }
}
