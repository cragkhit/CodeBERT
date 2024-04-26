@Test
public void testValidate02() throws Exception {
    SAXParserFactory spf = SAXParserFactory.newInstance();
    spf.setValidating ( true );
    spf.newSAXParser();
    assertTrue ( spf.isValidating() );
}
