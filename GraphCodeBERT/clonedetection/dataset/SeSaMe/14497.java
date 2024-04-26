public static String[] getJavaClassLibs() {
    String javaVersion = System.getProperty ( "java.version" );
    int index = javaVersion.indexOf ( '.' );
    if ( index != -1 ) {
        javaVersion = javaVersion.substring ( 0, index );
    } else {
        index = javaVersion.indexOf ( '-' );
        if ( index != -1 ) {
            javaVersion = javaVersion.substring ( 0, index );
        }
    }
    long jdkLevel = CompilerOptions.versionToJdkLevel ( javaVersion );
    if ( jdkLevel >= ClassFileConstants.JDK9 ) {
        String jreDir = getJREDirectory();
        return new String[] {
                   toNativePath ( jreDir + "/lib/jrt-fs.jar" )
               };
    }
    String bootclasspathProperty = System.getProperty ( "sun.boot.class.path" ); 
    if ( ( bootclasspathProperty == null ) || ( bootclasspathProperty.length() == 0 ) ) {
        bootclasspathProperty = System.getProperty ( "vm.boot.class.path" ); 
        if ( ( bootclasspathProperty == null ) || ( bootclasspathProperty.length() == 0 ) ) {
            bootclasspathProperty = System.getProperty ( "org.apache.harmony.boot.class.path" ); 
        }
    }
    String[] jars = null;
    if ( ( bootclasspathProperty != null ) && ( bootclasspathProperty.length() != 0 ) ) {
        StringTokenizer tokenizer = new StringTokenizer ( bootclasspathProperty, File.pathSeparator );
        final int size = tokenizer.countTokens();
        jars = new String[size];
        int i = 0;
        while ( tokenizer.hasMoreTokens() ) {
            final String fileName = toNativePath ( tokenizer.nextToken() );
            if ( new File ( fileName ).exists() ) {
                jars[i] = fileName;
                i++;
            }
        }
        if ( size != i ) {
            System.arraycopy ( jars, 0, ( jars = new String[i] ), 0, i );
        }
    } else {
        String jreDir = getJREDirectory();
        final String osName = System.getProperty ( "os.name" );
        if ( jreDir == null ) {
            return new String[] {};
        }
        if ( osName.startsWith ( "Mac" ) ) {
            return new String[] {
                       toNativePath ( jreDir + "/../Classes/classes.jar" )
                   };
        }
        final String vmName = System.getProperty ( "java.vm.name" );
        if ( "J9".equals ( vmName ) ) {
            return new String[] {
                       toNativePath ( jreDir + "/lib/jclMax/classes.zip" )
                   };
        }
        String[] jarsNames = null;
        ArrayList paths = new ArrayList();
        if ( "DRLVM".equals ( vmName ) ) {
            FilenameFilter jarFilter = new FilenameFilter() {
                public boolean accept ( File dir, String name ) {
                    return name.endsWith ( ".jar" ) & !name.endsWith ( "-src.jar" );
                }
            };
            jarsNames = new File ( jreDir + "/lib/boot/" ).list ( jarFilter );
            addJarEntries ( jreDir + "/lib/boot/", jarsNames, paths );
        } else {
            jarsNames = new String[] {
                "/lib/vm.jar",
                "/lib/rt.jar",
                "/lib/core.jar",
                "/lib/security.jar",
                "/lib/xml.jar",
                "/lib/graphics.jar"
            };
            addJarEntries ( jreDir, jarsNames, paths );
        }
        jars = new String[paths.size()];
        paths.toArray ( jars );
    }
    return jars;
}
