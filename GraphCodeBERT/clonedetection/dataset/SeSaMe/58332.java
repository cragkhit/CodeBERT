Name accessName ( int anum, int acode ) {
    return names.fromString (
               "access" + target.syntheticNameChar() + anum + acode / 10 + acode % 10 );
}
