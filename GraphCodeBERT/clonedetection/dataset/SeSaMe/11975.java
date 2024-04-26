public TypeBound[] flatten() {
    int size = 0;
    Iterator<ThreeSets> outerIt = this.boundsPerVariable.values().iterator();
    while ( outerIt.hasNext() ) {
        size += outerIt.next().size();
    }
    TypeBound[] collected = new TypeBound[size];
    if ( size == 0 ) {
        return collected;
    }
    outerIt = this.boundsPerVariable.values().iterator();
    int idx = 0;
    while ( outerIt.hasNext() ) {
        idx = outerIt.next().flattenInto ( collected, idx );
    }
    return collected;
}
