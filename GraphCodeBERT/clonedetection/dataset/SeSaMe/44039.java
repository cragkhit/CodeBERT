String getString ( int pos ) {
    char newStr[] = new char[strpos - pos];
    System.arraycopy ( str, pos, newStr, 0, strpos - pos );
    strpos = pos;
    return new String ( newStr );
}
