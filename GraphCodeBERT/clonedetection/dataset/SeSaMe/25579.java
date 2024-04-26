void storeStratum ( String stratumId ) {
    if ( stratumIndex > 0 ) {
        if ( ( stratumTable[stratumIndex - 1].fileIndex
                == fileIndex ) &&
                ( stratumTable[stratumIndex - 1].lineIndex
                  == lineIndex ) ) {
            --stratumIndex;
        }
    }
    assureStratumTableSize();
    stratumTable[stratumIndex].id = stratumId;
    stratumTable[stratumIndex].fileIndex = fileIndex;
    stratumTable[stratumIndex].lineIndex = lineIndex;
    ++stratumIndex;
    currentFileId = 0;
}
