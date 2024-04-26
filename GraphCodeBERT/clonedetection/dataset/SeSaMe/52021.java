public NodeSetDTM mutableNodeset()
throws javax.xml.transform.TransformerException {
    error ( XPATHErrorResources.ER_CANT_CONVERT_TO_MUTABLENODELIST,
            new Object[] { getTypeString() } ); 
    return ( NodeSetDTM ) m_obj;
}
