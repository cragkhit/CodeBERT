public void adjustIndentation ( int delta ) {
    if ( delta < 0 ) {
        indentationLevel = Math.max ( 0, indentationLevel + delta );
    } else {
        indentationLevel += delta;
    }
}
