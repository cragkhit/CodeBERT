public void testGetResource01 ( Element e, String arg0, String arg1 ) throws Exception {
    FileObject resource = _filer.getResource ( StandardLocation.SOURCE_OUTPUT, arg0, arg1 );
    checkResourceContents01 ( resource, resource01Name, resource01FileContents );
}
