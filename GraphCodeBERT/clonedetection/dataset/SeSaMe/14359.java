protected IJavaElementDelta[] removeAndShrinkArray ( IJavaElementDelta[] old, int index ) {
    IJavaElementDelta[] array = new IJavaElementDelta[old.length - 1];
    if ( index > 0 ) {
        System.arraycopy ( old, 0, array, 0, index );
    }
    int rest = old.length - index - 1;
    if ( rest > 0 ) {
        System.arraycopy ( old, index + 1, array, index, rest );
    }
    return array;
}
