protected Object readResolve() throws java.io.ObjectStreamException {
    try {
        CertificateFactory cf = CertificateFactory.getInstance ( type );
        return cf.generateCertificate
               ( new java.io.ByteArrayInputStream ( data ) );
    } catch ( CertificateException e ) {
        throw new java.io.NotSerializableException
        ( "java.security.cert.Certificate: " +
          type +
          ": " +
          e.getMessage() );
    }
}
