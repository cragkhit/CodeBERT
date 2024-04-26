public static void init() {
    _tmpFolder = System.getProperty ( "java.io.tmpdir" );
    if ( _tmpFolder.endsWith ( File.separator ) ) {
        _tmpFolder += "eclipse-temp";
    } else {
        _tmpFolder += ( File.separator + "eclipse-temp" );
    }
    _tmpBinFolderName = _tmpFolder + File.separator + "bin";
    _tmpBinDir = new File ( _tmpBinFolderName );
    BatchTestUtils.deleteTree ( _tmpBinDir ); 
    _tmpBinDir.mkdirs();
    assert _tmpBinDir.exists() : "couldn't mkdirs " + _tmpBinFolderName;
    _tmpGenFolderName = _tmpFolder + File.separator + "gen-src";
    _tmpGenDir = new File ( _tmpGenFolderName );
    BatchTestUtils.deleteTree ( _tmpGenDir ); 
    _tmpGenDir.mkdirs();
    assert _tmpGenDir.exists() : "couldn't mkdirs " + _tmpGenFolderName;
    _tmpSrcFolderName = _tmpFolder + File.separator + "src";
    _tmpSrcDir = new File ( _tmpSrcFolderName );
    BatchTestUtils.deleteTree ( _tmpSrcDir ); 
    _tmpSrcDir.mkdirs();
    assert _tmpSrcDir.exists() : "couldn't mkdirs " + _tmpSrcFolderName;
    try {
        _processorJarPath = setupProcessorJar ( PROCESSOR_JAR_NAME, _tmpFolder );
        _jls8ProcessorJarPath = setupProcessorJar ( JLS8_PROCESSOR_JAR_NAME, _tmpFolder );
    } catch ( IOException e ) {
        e.printStackTrace();
    }
    junit.framework.TestCase.assertNotNull ( "No processor jar path set", _processorJarPath );
    File processorJar = new File ( _processorJarPath );
    junit.framework.TestCase.assertTrue ( "Couldn't find processor jar at " + processorJar.getAbsolutePath(), processorJar.exists() );
    ServiceLoader<JavaCompiler> javaCompilerLoader = ServiceLoader.load ( JavaCompiler.class, BatchTestUtils.class.getClassLoader() );
    Class<?> c = null;
    try {
        c = Class.forName ( "org.eclipse.jdt.internal.compiler.tool.EclipseCompiler" );
    } catch ( ClassNotFoundException e ) {
    }
    if ( c == null ) {
        junit.framework.TestCase.assertTrue ( "Eclipse compiler is not available", false );
    }
    for ( JavaCompiler javaCompiler : javaCompilerLoader ) {
        if ( c.isInstance ( javaCompiler ) ) {
            _eclipseCompiler = javaCompiler;
        }
    }
    junit.framework.TestCase.assertNotNull ( "No Eclipse compiler found", _eclipseCompiler );
}
