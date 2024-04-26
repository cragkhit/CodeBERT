public boolean hasSameValue ( Constant otherConstant ) {
    if ( this == otherConstant ) {
        return true;
    }
    int typeID;
    if ( ( typeID = typeID() ) != otherConstant.typeID() ) {
        return false;
    }
    switch ( typeID ) {
    case TypeIds.T_boolean:
        return booleanValue() == otherConstant.booleanValue();
    case TypeIds.T_byte:
        return byteValue() == otherConstant.byteValue();
    case TypeIds.T_char:
        return charValue() == otherConstant.charValue();
    case TypeIds.T_double:
        return doubleValue() == otherConstant.doubleValue();
    case TypeIds.T_float:
        return floatValue() == otherConstant.floatValue();
    case TypeIds.T_int:
        return intValue() == otherConstant.intValue();
    case TypeIds.T_short:
        return shortValue() == otherConstant.shortValue();
    case TypeIds.T_long:
        return longValue() == otherConstant.longValue();
    case TypeIds.T_JavaLangString:
        String value = stringValue();
        return value == null
               ? otherConstant.stringValue() == null
               : value.equals ( otherConstant.stringValue() );
    }
    return false;
}
