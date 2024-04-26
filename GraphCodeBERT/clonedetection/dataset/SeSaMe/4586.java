protected void resetInternalState() {
    setStepStart ( null );
    setStepSize ( minStep.multiply ( maxStep ).sqrt() );
}
