public void setHeaderFile ( URI uri ) throws CheckstyleException {
    if ( uri == null ) {
        throw new CheckstyleException (
            "property 'headerFile' is missing or invalid in module "
            + getConfiguration().getName() );
    }
    headerFile = uri;
}
