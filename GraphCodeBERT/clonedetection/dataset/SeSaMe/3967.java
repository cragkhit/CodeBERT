public void removeMostRecentValue() throws MathIllegalStateException {
    try {
        eDA.discardMostRecentElements ( 1 );
    } catch ( MathIllegalArgumentException ex ) {
        throw new MathIllegalStateException ( LocalizedFormats.NO_DATA );
    }
}
