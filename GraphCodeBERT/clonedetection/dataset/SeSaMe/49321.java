public void unindent() {
    _nextIndent -= _format.getIndent();
    if ( _nextIndent < 0 ) {
        _nextIndent = 0;
    }
    if ( ( _line.length() + _spaces + _text.length() ) == 0 ) {
        _thisIndent = _nextIndent;
    }
}
