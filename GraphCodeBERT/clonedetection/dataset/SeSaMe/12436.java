public MethodBinding getMethodBinding() {
    if ( this.methodBinding == null ) {
        Scope scope = this.block.scope;
        this.methodBinding = isStatic()
                             ? new MethodBinding ( ClassFileConstants.AccStatic, CharOperation.NO_CHAR, TypeBinding.VOID, Binding.NO_PARAMETERS, Binding.NO_EXCEPTIONS, scope.enclosingSourceType() )
                             : new MethodBinding ( 0, CharOperation.NO_CHAR, TypeBinding.VOID, Binding.NO_PARAMETERS, Binding.NO_EXCEPTIONS, scope.enclosingSourceType() );
    }
    return this.methodBinding;
}
