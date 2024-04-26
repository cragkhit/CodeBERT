protected void resolveDuplicates ( SourceRefElement handle ) {
    int occurenceCount = this.occurenceCounts.get ( handle );
    if ( occurenceCount == -1 ) {
        this.occurenceCounts.put ( handle, 1 );
    } else {
        this.occurenceCounts.put ( handle, ++occurenceCount );
        handle.occurrenceCount = occurenceCount;
    }
    if ( handle instanceof SourceType && ( ( SourceType ) handle ).isAnonymous() ) {
        Object key = handle.getParent().getAncestor ( IJavaElement.TYPE );
        occurenceCount = this.localOccurrenceCounts.get ( key );
        if ( occurenceCount == -1 ) {
            this.localOccurrenceCounts.put ( key, 1 );
        } else {
            this.localOccurrenceCounts.put ( key, ++occurenceCount );
            ( ( SourceType ) handle ).localOccurrenceCount = occurenceCount;
        }
    }
}
