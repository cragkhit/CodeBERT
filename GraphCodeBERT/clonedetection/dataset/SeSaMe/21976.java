public void waitState ( final int state ) {
    getOutput().printLine ( "Wait frame to have "
                            + Integer.toString ( state )
                            + " state \n    : "
                            + toStringSource() );
    getOutput().printGolden ( "Wait frame to have "
                              + Integer.toString ( state )
                              + " state" );
    waitState ( new ComponentChooser() {
        @Override
        public boolean checkComponent ( Component comp ) {
            return ( ( Frame ) comp ).getExtendedState() == state;
        }
        @Override
        public String getDescription() {
            return Integer.toString ( state ) + " state";
        }
        @Override
        public String toString() {
            return "FrameOperator.waitState.ComponentChooser{description = " + getDescription() + '}';
        }
    } );
}
