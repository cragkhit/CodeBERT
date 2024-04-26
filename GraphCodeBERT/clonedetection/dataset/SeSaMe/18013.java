@CanIgnoreReturnValue
public CharEscaperBuilder addEscape ( char c, String r ) {
    map.put ( c, checkNotNull ( r ) );
    if ( c > max ) {
        max = c;
    }
    return this;
}
