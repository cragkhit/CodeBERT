protected Object readState ( IProject project ) throws CoreException {
    File file = getSerializationFile ( project );
    if ( file != null && file.exists() ) {
        try {
            DataInputStream in = new DataInputStream ( new BufferedInputStream ( new FileInputStream ( file ) ) );
            try {
                String pluginID = in.readUTF();
                if ( !pluginID.equals ( JavaCore.PLUGIN_ID ) ) {
                    throw new IOException ( Messages.build_wrongFileFormat );
                }
                String kind = in.readUTF();
                if ( !kind.equals ( "STATE" ) ) { 
                    throw new IOException ( Messages.build_wrongFileFormat );
                }
                if ( in.readBoolean() ) {
                    return JavaBuilder.readState ( project, in );
                }
                if ( JavaBuilder.DEBUG ) {
                    System.out.println ( "Saved state thinks last build failed for " + project.getName() );    
                }
            } finally {
                in.close();
            }
        } catch ( Exception e ) {
            e.printStackTrace();
            throw new CoreException ( new Status ( IStatus.ERROR, JavaCore.PLUGIN_ID, Platform.PLUGIN_ERROR, "Error reading last build state for project " + project.getName(), e ) ); 
        }
    } else if ( JavaBuilder.DEBUG ) {
        if ( file == null ) {
            System.out.println ( "Project does not exist: " + project );    
        } else {
            System.out.println ( "Build state file " + file.getPath() + " does not exist" );    
        }
    }
    return null;
}
