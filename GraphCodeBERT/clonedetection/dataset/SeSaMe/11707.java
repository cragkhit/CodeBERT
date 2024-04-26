public char[] getImport ( int lineNumber ) {
    int importStartLine = this.lineNumberOffset - 1 - this.snippetImports.length;
    return this.snippetImports[lineNumber - importStartLine];
}
