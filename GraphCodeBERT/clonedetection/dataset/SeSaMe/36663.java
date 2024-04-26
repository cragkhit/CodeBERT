boolean isRuntimeException() {
    return tsym.isSubClass ( env.syms.runtimeExceptionType.tsym, env.types );
}
