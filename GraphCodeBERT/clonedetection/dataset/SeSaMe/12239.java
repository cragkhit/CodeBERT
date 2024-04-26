public UnconditionalFlowInfo discardNonFieldInitializations() {
    int limit = this.maxFieldCount;
    if ( limit < BitCacheSize ) {
        long mask = ( 1L << limit ) - 1;
        this.definiteInits &= mask;
        this.potentialInits &= mask;
        this.nullBit1 &= mask;
        this.nullBit2 &= mask;
        this.nullBit3 &= mask;
        this.nullBit4 &= mask;
        this.iNBit &= mask;
        this.iNNBit &= mask;
    }
    if ( this.extra == null ) {
        return this; 
    }
    int vectorIndex, length = this.extra[0].length;
    if ( ( vectorIndex = ( limit / BitCacheSize ) - 1 ) >= length ) {
        return this; 
    }
    if ( vectorIndex >= 0 ) {
        long mask = ( 1L << ( limit % BitCacheSize ) ) - 1;
        for ( int j = 0; j < extraLength; j++ ) {
            this.extra[j][vectorIndex] &= mask;
        }
    }
    for ( int i = vectorIndex + 1; i < length; i++ ) {
        for ( int j = 0; j < extraLength; j++ ) {
            this.extra[j][i] = 0;
        }
    }
    return this;
}
