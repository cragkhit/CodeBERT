public void printFlags ( long flags ) throws IOException {
    if ( ( flags & SYNTHETIC ) != 0 ) {
        print ( "/*synthetic*/ " );
    }
    print ( TreeInfo.flagNames ( flags ) );
    if ( ( flags & ExtendedStandardFlags ) != 0 ) {
        print ( " " );
    }
    if ( ( flags & ANNOTATION ) != 0 ) {
        print ( "@" );
    }
}
