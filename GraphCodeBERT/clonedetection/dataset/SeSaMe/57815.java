public boolean isMember ( int x ) {
    Assert.check ( currentState != BitsState.UNKNOWN );
    return
        0 <= x && x < ( bits.length << wordshift ) &&
        ( bits[x >>> wordshift] & ( 1 << ( x & wordmask ) ) ) != 0;
}
