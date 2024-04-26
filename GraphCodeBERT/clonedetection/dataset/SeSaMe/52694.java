protected int getFieldSize ( final ConstantPoolGen cpg ) {
    return Type.size ( Type.getTypeSize ( getSignature ( cpg ) ) );
}
