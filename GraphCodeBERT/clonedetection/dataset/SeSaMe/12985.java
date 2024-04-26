public void setRightOperand ( Type referenceType ) {
    if ( referenceType == null ) {
        throw new IllegalArgumentException();
    }
    ASTNode oldChild = this.rightOperand;
    preReplaceChild ( oldChild, referenceType, RIGHT_OPERAND_PROPERTY );
    this.rightOperand = referenceType;
    postReplaceChild ( oldChild, referenceType, RIGHT_OPERAND_PROPERTY );
}
