public BatchEnvironment getEnv() {
    ClassPath classPath =
        BatchEnvironment.createClassPath ( classPathString,
                                           sysClassPathArg );
    BatchEnvironment result = null;
    try {
        Class<?>[] ctorArgTypes = {OutputStream.class, ClassPath.class, Main.class};
        Object[] ctorArgs = {out, classPath, this};
        Constructor<? extends BatchEnvironment> constructor =
            environmentClass.getConstructor ( ctorArgTypes );
        result =  constructor.newInstance ( ctorArgs );
        result.reset();
    } catch ( Exception e ) {
        error ( "rmic.cannot.instantiate", environmentClass.getName() );
    }
    return result;
}
