public void translate ( ClassGenerator classGen, MethodGenerator methodGen ) {
    if ( _fallbacks != null ) {
        int count = _fallbacks.size();
        for ( int i = 0; i < count; i++ ) {
            Fallback fallback = ( Fallback ) _fallbacks.get ( i );
            fallback.translate ( classGen, methodGen );
        }
    }
    else {
        ConstantPoolGen cpg = classGen.getConstantPool();
        InstructionList il = methodGen.getInstructionList();
        final int unsupportedElem = cpg.addMethodref ( BASIS_LIBRARY_CLASS, "unsupported_ElementF",
                                    "(" + STRING_SIG + "Z)V" );
        il.append ( new PUSH ( cpg, getQName().toString() ) );
        il.append ( new PUSH ( cpg, _isExtension ) );
        il.append ( new INVOKESTATIC ( unsupportedElem ) );
    }
}
