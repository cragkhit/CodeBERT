public int getLineNo() {
    int resultNo = -1;
    if ( lineNo == NOT_INITIALIZED ) {
        resultNo = findLineNo ( getFirstChild() );
        if ( resultNo == -1 ) {
            resultNo = findLineNo ( getNextSibling() );
        }
    }
    if ( resultNo == -1 ) {
        resultNo = lineNo;
    }
    return resultNo;
}
