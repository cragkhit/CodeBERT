public static FileSystem open() {
    synchronized ( lock ) {
        if ( fs == null ) {
            fs = new FileSystemImpl();
        }
        return fs;
    }
}
