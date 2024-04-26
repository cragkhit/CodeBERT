public AttributeSet currentSectionAttributes() {
    MutableAttributeSet attributes = new SimpleAttributeSet ( sectionAttributes );
    Style sectionStyle = ( Style ) parserState.get ( "sectionStyle" );
    if ( sectionStyle != null ) {
        attributes.setResolveParent ( sectionStyle );
    }
    return attributes;
}
