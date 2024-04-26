public byte[] getEncodedInfo() throws CertificateEncodingException {
    try {
        if ( rawCertInfo == null ) {
            DerOutputStream tmp = new DerOutputStream();
            emit ( tmp );
            rawCertInfo = tmp.toByteArray();
        }
        return rawCertInfo.clone();
    } catch ( IOException e ) {
        throw new CertificateEncodingException ( e.toString() );
    } catch ( CertificateException e ) {
        throw new CertificateEncodingException ( e.toString() );
    }
}
