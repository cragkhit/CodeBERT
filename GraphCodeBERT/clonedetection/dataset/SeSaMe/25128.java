public void runRelativePathTest ( String javaFileName, String fileName,
                                  boolean bodyOnly ) throws Exception  {
    List<File> javaFiles = new ArrayList<>();
    javaFiles.add ( new File ( testSrc, javaFileName ) );
    List<File> dirs = new ArrayList<>();
    dirs.add ( new File ( testSrc ) );
    try ( StandardJavaFileManager fm = javac.getStandardFileManager ( null, null, null ) ) {
        fm.setLocation ( javax.tools.StandardLocation.SOURCE_PATH, dirs );
        Iterable<? extends JavaFileObject> fos = fm.getJavaFileObjectsFromFiles ( javaFiles );
        final JavacTask t = javac.getTask ( null, fm, null, null, null, fos );
        final DocTrees trees = DocTrees.instance ( t );
        Iterable<? extends Element> elements = t.analyze();
        Element klass = elements.iterator().next();
        DocCommentTree dcTree = trees.getDocCommentTree ( klass, fileName );
        if ( dcTree == null ) {
            throw new Error ( "invalid input: " + fileName );
        }
        StringWriter sw = new StringWriter();
        printer.print ( dcTree, sw );
        String found = sw.toString();
        FileObject htmlFo = fm.getFileForInput ( javax.tools.StandardLocation.SOURCE_PATH,
                            t.getElements().getPackageOf ( klass ).getQualifiedName().toString(),
                            fileName + ".out" );
        String expected = getExpected ( htmlFo.openReader ( true ) );
        astcheck ( fileName, expected, found );
    }
}
