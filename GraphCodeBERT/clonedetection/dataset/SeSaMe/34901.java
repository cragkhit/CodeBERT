@Function ( attributes = Attribute.NOT_ENUMERABLE, where = Where.CONSTRUCTOR )
public static double round ( final Object self, final Object x ) {
    final double d = JSType.toNumber ( x );
    if ( Math.getExponent ( d ) >= 52 ) {
        return d;
    }
    return Math.copySign ( Math.floor ( d + 0.5 ), d );
}
