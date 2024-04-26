public int getIntCount ( int value ) {
    assert ( phase() == DISBURSE_PHASE );
    assert ( valuesRemainingForDebug() == length() );
    int total = 0;
    for ( int k = length(); k > 0; k-- ) {
        if ( getInt() == value ) {
            total += 1;
        }
    }
    resetForSecondPass();
    return total;
}
