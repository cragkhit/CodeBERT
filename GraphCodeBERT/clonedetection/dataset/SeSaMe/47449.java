public final void requestDelegPolicy ( boolean value ) {
    if ( state == STATE_NEW && isInitiator() ) {
        delegPolicyState = value;
    }
}
