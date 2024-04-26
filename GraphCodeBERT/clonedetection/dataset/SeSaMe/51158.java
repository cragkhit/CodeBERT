public String getAttributeLocalName ( int index ) {
    if ( fEventType == XMLEvent.START_ELEMENT || fEventType == XMLEvent.ATTRIBUTE ) {
        return fScanner.getAttributeIterator().getLocalName ( index );
    } else {
        throw new java.lang.IllegalStateException();
    }
}
