public void printFunction ( DifferentialFunction differentialFunction ) {
    if ( !logExecution ) {
        return;
    }
    if ( differentialFunction instanceof SDVariable ) {
        return;
    }
    StringBuilder argShapes = new StringBuilder();
    for ( val arg : differentialFunction.args() ) {
        argShapes.append ( " Variable " + arg.getVarName() +
                           " Shape for " + Arrays.toString ( arg.getShape() ) );
    }
    for ( val func : differentialFunction.outputVariables() ) {
        argShapes.append ( "  Output variable " + func.getVarName() + " is " +
                           Arrays.toString ( func.getShape() ) );
    }
    StringBuilder realShapes = new StringBuilder();
    for ( val arg : differentialFunction.args() ) {
        realShapes.append ( " Input shape for " + arg.getVarName() + " is  " + Arrays.
                            toString ( getShapeForVarName ( arg.getVarName() ) ) );
    }
    for ( val arg : differentialFunction.outputVariables() ) {
        realShapes.append ( " Output shape for " + arg.getVarName() + " is  " + Arrays.
                            toString ( getShapeForVarName ( arg.getVarName() ) ) );
    }
}
