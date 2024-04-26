void compile ( Iterable<? extends JavaFileObject> files ) throws IOException {
    String name = "compile" + ( compileCount++ );
    try ( StandardJavaFileManager fm = comp.getStandardFileManager ( null, null, null ) ) {
        File f = new File ( name );
        f.mkdirs();
        fm.setLocation ( StandardLocation.CLASS_OUTPUT, Collections.singleton ( f ) );
        boolean ok = comp.getTask ( null, fm, null, null, null, files ).call();
        if ( !ok ) {
            error ( name + ": compilation failed" );
        }
    }
}
