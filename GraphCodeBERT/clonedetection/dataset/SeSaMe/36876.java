public static int getMnemonicInt ( String message ) {
    Integer integer = MNEMONIC_LOOKUP.get ( message );
    if ( integer != null ) {
        return integer.intValue();
    }
    return 0;
}
