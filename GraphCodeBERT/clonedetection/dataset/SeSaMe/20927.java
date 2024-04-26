public int testAttach() throws Exception {
    DynamicVMOption option = new DynamicVMOption ( name );
    int failedTests = 0;
    String origValue;
    if ( option.isWriteable() ) {
        System.out.println ( "Testing " + name + " option dynamically via attach" );
        origValue = option.getValue();
        HotSpotVirtualMachine vm = ( HotSpotVirtualMachine ) VirtualMachine.attach ( String.valueOf ( ProcessTools.getProcessId() ) );
        for ( String value : getValidValues() ) {
            if ( !setFlagAttach ( vm, name, value ) ) {
                failedMessage ( String.format ( "Option %s: Can not change option to valid value \"%s\" via attach", name, value ) );
                failedTests++;
            }
        }
        for ( String value : getInvalidValues() ) {
            if ( setFlagAttach ( vm, name, value ) ) {
                failedMessage ( String.format ( "Option %s: Option changed to invalid value \"%s\" via attach", name, value ) );
                failedTests++;
            }
        }
        vm.detach();
        option.setValue ( origValue );
    }
    return failedTests;
}
