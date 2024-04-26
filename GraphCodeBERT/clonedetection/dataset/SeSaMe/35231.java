public SwitchPoint newBuiltinSwitchPoint ( final String name ) {
    assert builtinSwitchPoints.get ( name ) == null;
    final SwitchPoint sp = new BuiltinSwitchPoint();
    builtinSwitchPoints.put ( name, sp );
    return sp;
}
