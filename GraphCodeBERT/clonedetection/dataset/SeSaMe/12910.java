protected int retrieveEllipsisStartPosition ( int start, int end ) {
    this.scanner.resetTo ( start, end );
    try {
        int token;
        while ( ( token = this.scanner.getNextToken() ) != TerminalTokens.TokenNameEOF ) {
            switch ( token ) {
            case TerminalTokens.TokenNameELLIPSIS:
                return this.scanner.startPosition - 1;
            }
        }
    } catch ( InvalidInputException e ) {
    }
    return -1;
}
