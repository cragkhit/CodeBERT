public void setCharset ( String charset ) throws UnsupportedEncodingException {
    if ( !Charset.isSupported ( charset ) ) {
        final String message = "unsupported charset: '" + charset + "'";
        throw new UnsupportedEncodingException ( message );
    }
    this.charset = charset;
}
