@Override
public boolean isSameFile ( DocFile other ) {
    if ( ! ( other instanceof StandardDocFile ) ) {
        return false;
    }
    try {
        return Files.isSameFile ( file, ( ( StandardDocFile ) other ).file );
    } catch ( IOException e ) {
        return false;
    }
}
