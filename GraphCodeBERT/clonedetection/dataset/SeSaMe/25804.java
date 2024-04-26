@Override
public int previous() {
    CharacterIterator text = getText();
    if ( cachedBreakPositions != null && positionInCache > 0 ) {
        --positionInCache;
        text.setIndex ( cachedBreakPositions[positionInCache] );
        return cachedBreakPositions[positionInCache];
    }
    else {
        cachedBreakPositions = null;
        int result = super.previous();
        if ( cachedBreakPositions != null ) {
            positionInCache = cachedBreakPositions.length - 2;
        }
        return result;
    }
}
