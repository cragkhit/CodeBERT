public static boolean isAlpha ( String str ) {
    if ( str == null ) {
        return false;
    }
    int sz = str.length();
    for ( int i = 0; i < sz; i++ ) {
        if ( !Character.isLetter ( str.charAt ( i ) ) ) {
            return false;
        }
    }
    return true;
}
