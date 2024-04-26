public static TextLine standardCreateTextLine ( FontRenderContext frc,
        AttributedCharacterIterator text,
        char[] chars,
        float[] baselineOffsets ) {
    StyledParagraph styledParagraph = new StyledParagraph ( text, chars );
    Bidi bidi = new Bidi ( text );
    if ( bidi.isLeftToRight() ) {
        bidi = null;
    }
    int layoutFlags = 0; 
    TextLabelFactory factory = new TextLabelFactory ( frc, chars, bidi, layoutFlags );
    boolean isDirectionLTR = true;
    if ( bidi != null ) {
        isDirectionLTR = bidi.baseIsLeftToRight();
    }
    return createLineFromText ( chars, styledParagraph, factory, isDirectionLTR, baselineOffsets );
}
