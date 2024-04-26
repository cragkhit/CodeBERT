protected void startNode ( Node node ) throws org.xml.sax.SAXException {
    if ( node instanceof Locator ) {
        Locator loc = ( Locator ) node;
        m_locator.setColumnNumber ( loc.getColumnNumber() );
        m_locator.setLineNumber ( loc.getLineNumber() );
        m_locator.setPublicId ( loc.getPublicId() );
        m_locator.setSystemId ( loc.getSystemId() );
    } else {
        m_locator.setColumnNumber ( 0 );
        m_locator.setLineNumber ( 0 );
    }
    switch ( node.getNodeType() ) {
    case Node.COMMENT_NODE : {
        String data = ( ( Comment ) node ).getData();
        if ( m_contentHandler instanceof LexicalHandler ) {
            LexicalHandler lh = ( ( LexicalHandler ) this.m_contentHandler );
            lh.comment ( data.toCharArray(), 0, data.length() );
        }
    }
    break;
    case Node.DOCUMENT_FRAGMENT_NODE :
        break;
    case Node.DOCUMENT_NODE :
        break;
    case Node.ELEMENT_NODE :
        Element elem_node = ( Element ) node;
        {
            String uri = elem_node.getNamespaceURI();
            if ( uri != null ) {
                String prefix = elem_node.getPrefix();
                if ( prefix == null ) {
                    prefix = "";
                }
                this.m_contentHandler.startPrefixMapping ( prefix, uri );
            }
        }
        NamedNodeMap atts = elem_node.getAttributes();
        int nAttrs = atts.getLength();
        for ( int i = 0; i < nAttrs; i++ ) {
            final Node attr = atts.item ( i );
            final String attrName = attr.getNodeName();
            final int colon = attrName.indexOf ( ':' );
            final String prefix;
            if ( attrName.equals ( "xmlns" ) || attrName.startsWith ( "xmlns:" ) ) {
                if ( colon < 0 ) {
                    prefix = "";
                } else {
                    prefix = attrName.substring ( colon + 1 );
                }
                this.m_contentHandler.startPrefixMapping ( prefix,
                        attr.getNodeValue() );
            } else if ( colon > 0 ) {
                prefix = attrName.substring ( 0, colon );
                String uri = attr.getNamespaceURI();
                if ( uri != null ) {
                    this.m_contentHandler.startPrefixMapping ( prefix, uri );
                }
            }
        }
        String ns = DOM2Helper.getNamespaceOfNode ( node );
        if ( null == ns ) {
            ns = "";
        }
        this.m_contentHandler.startElement ( ns,
                                             DOM2Helper.getLocalNameOfNode ( node ),
                                             node.getNodeName(),
                                             new AttList ( atts ) );
        break;
    case Node.PROCESSING_INSTRUCTION_NODE : {
        ProcessingInstruction pi = ( ProcessingInstruction ) node;
        String name = pi.getNodeName();
        if ( name.equals ( "xslt-next-is-raw" ) ) {
            nextIsRaw = true;
        } else {
            this.m_contentHandler.processingInstruction ( pi.getNodeName(),
                    pi.getData() );
        }
    }
    break;
    case Node.CDATA_SECTION_NODE : {
        boolean isLexH = ( m_contentHandler instanceof LexicalHandler );
        LexicalHandler lh = isLexH
                            ? ( ( LexicalHandler ) this.m_contentHandler ) : null;
        if ( isLexH ) {
            lh.startCDATA();
        }
        dispatachChars ( node );
        {
            if ( isLexH ) {
                lh.endCDATA();
            }
        }
    }
    break;
    case Node.TEXT_NODE : {
        if ( nextIsRaw ) {
            nextIsRaw = false;
            m_contentHandler.processingInstruction ( Result.PI_DISABLE_OUTPUT_ESCAPING, "" );
            dispatachChars ( node );
            m_contentHandler.processingInstruction ( Result.PI_ENABLE_OUTPUT_ESCAPING, "" );
        } else {
            dispatachChars ( node );
        }
    }
    break;
    case Node.ENTITY_REFERENCE_NODE : {
        EntityReference eref = ( EntityReference ) node;
        if ( m_contentHandler instanceof LexicalHandler ) {
            ( ( LexicalHandler ) this.m_contentHandler ).startEntity (
                eref.getNodeName() );
        } else {
        }
    }
    break;
    default :
    }
}
