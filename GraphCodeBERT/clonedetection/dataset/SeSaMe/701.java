public Pattern getPattern() {
    if ( pattern == null ) {
        int options = compileFlags;
        if ( ignoreCase ) {
            options |= Pattern.CASE_INSENSITIVE;
        }
        pattern = Pattern.compile ( format, options );
    }
    return pattern;
}
