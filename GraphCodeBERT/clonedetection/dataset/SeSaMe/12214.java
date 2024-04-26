public void becomeDelegateFor ( BranchLabel otherLabel ) {
    otherLabel.delegate = this;
    final int otherCount = otherLabel.forwardReferenceCount;
    if ( otherCount == 0 ) {
        return;
    }
    int[] mergedForwardReferences = new int[this.forwardReferenceCount + otherCount];
    int indexInMerge = 0;
    int j = 0;
    int i = 0;
    int max = this.forwardReferenceCount;
    int max2 = otherLabel.forwardReferenceCount;
    loop1 : for ( ; i < max; i++ ) {
        final int value1 = this.forwardReferences[i];
        for ( ; j < max2; j++ ) {
            final int value2 = otherLabel.forwardReferences[j];
            if ( value1 < value2 ) {
                mergedForwardReferences[indexInMerge++] = value1;
                continue loop1;
            } else if ( value1 == value2 ) {
                mergedForwardReferences[indexInMerge++] = value1;
                j++;
                continue loop1;
            } else {
                mergedForwardReferences[indexInMerge++] = value2;
            }
        }
        mergedForwardReferences[indexInMerge++] = value1;
    }
    for ( ; j < max2; j++ ) {
        mergedForwardReferences[indexInMerge++] = otherLabel.forwardReferences[j];
    }
    this.forwardReferences = mergedForwardReferences;
    this.forwardReferenceCount = indexInMerge;
}
