Object getAdjustField ( int start, Map<?, ?> attributes ) {
    Iterator<?> attrs = attributes.keySet().iterator();
    while ( attrs.hasNext() ) {
        Object key = attrs.next();
        if ( ( key instanceof DateFormat.Field ) &&
                ( key == DateFormat.Field.HOUR1 ||
                  ( ( DateFormat.Field ) key ).getCalendarField() != -1 ) ) {
            return key;
        }
    }
    return null;
}
