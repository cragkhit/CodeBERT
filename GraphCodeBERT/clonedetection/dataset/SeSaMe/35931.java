void _goto ( final Label label ) {
    debug ( "goto", label );
    jump ( GOTO, label, 0 );
    doesNotContinueSequentially(); 
}
