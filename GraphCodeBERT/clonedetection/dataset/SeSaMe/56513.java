public long getRawPrimitive ( Object object, int index ) {
    long offset = offsets[index];
    Class<?> type = types[index];
    if ( type == Integer.TYPE ) {
        return UNSAFE.getInt ( object, offset );
    } else if ( type == Long.TYPE ) {
        return UNSAFE.getLong ( object, offset );
    } else if ( type == Boolean.TYPE ) {
        return UNSAFE.getBoolean ( object, offset ) ? 1 : 0;
    } else if ( type == Float.TYPE ) {
        return Float.floatToRawIntBits ( UNSAFE.getFloat ( object, offset ) );
    } else if ( type == Double.TYPE ) {
        return Double.doubleToRawLongBits ( UNSAFE.getDouble ( object, offset ) );
    } else if ( type == Short.TYPE ) {
        return UNSAFE.getShort ( object, offset );
    } else if ( type == Character.TYPE ) {
        return UNSAFE.getChar ( object, offset );
    } else if ( type == Byte.TYPE ) {
        return UNSAFE.getByte ( object, offset );
    } else {
        throw GraalError.shouldNotReachHere();
    }
}
