public void generateStringConcatenationAppend ( BlockScope blockScope, Expression oper1, Expression oper2 ) {
    int pc;
    if ( oper1 == null ) {
        this.newStringContatenation();
        this.dup_x1();
        this.swap();
        this.invokeStringValueOf ( T_Object );
        this.invokeStringConcatenationStringConstructor();
    } else {
        pc = position;
        oper1.generateOptimizedStringConcatenationCreation ( blockScope, this, oper1.implicitConversion & 0xF );
        this.recordPositionsFrom ( pc, oper1.sourceStart );
    }
    pc = position;
    oper2.generateOptimizedStringConcatenation ( blockScope, this, oper2.implicitConversion & 0xF );
    this.recordPositionsFrom ( pc, oper2.sourceStart );
    this.invokeStringConcatenationToString();
}
