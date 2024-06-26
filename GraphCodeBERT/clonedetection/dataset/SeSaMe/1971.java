public static boolean isAlpha ( final CharSequence cs ) {
    if ( isEmpty ( cs ) ) {
        return false;
    }
    final int sz = cs.length();
    for ( int i = 0; i < sz; i++ ) {
        if ( !Character.isLetter ( cs.charAt ( i ) ) ) {
            return false;
        }
    }
    return true;
}
