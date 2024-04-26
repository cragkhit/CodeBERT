@Test
public void testCheckingUserData() throws Exception {
    String xmlFile = XML_DIR + "accountInfo.xml";
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    dbf.setNamespaceAware ( true );
    DocumentBuilder docBuilder = dbf.newDocumentBuilder();
    Document document = docBuilder.parse ( xmlFile );
    Element account = ( Element ) document.getElementsByTagNameNS ( PORTAL_ACCOUNT_NS, "Account" ).item ( 0 );
    assertEquals ( account.getNodeName(), "acc:Account" );
    Element firstName = ( Element ) document.getElementsByTagNameNS ( PORTAL_ACCOUNT_NS, "FirstName" ).item ( 0 );
    assertEquals ( firstName.getNodeName(), "FirstName" );
    Document doc1 = docBuilder.newDocument();
    Element someName = doc1.createElement ( "newelem" );
    someName.setUserData ( "mykey", "dd",
    ( operation, key,  data, src,  dst ) ->  {
        System.err.println ( "In UserDataHandler" + key );
        System.out.println ( "In UserDataHandler" );
    } );
    Element impAccount = ( Element ) document.importNode ( someName, true );
    assertEquals ( impAccount.getNodeName(), "newelem" );
    document.normalizeDocument();
    String data = ( someName.getUserData ( "mykey" ) ).toString();
    assertEquals ( data, "dd" );
}
