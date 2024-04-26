public int compareTo ( Span otherSpan ) {
    float otherStart = otherSpan.getStart();
    int result;
    if ( mStart < otherStart ) {
        result = -1;
    } else if ( mStart > otherStart ) {
        result = 1;
    } else {
        result = 0;
    }
    return result;
}
