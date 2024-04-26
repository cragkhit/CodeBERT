protected Object configureValue ( Object value ) {
    if ( value != null ) {
        if ( value instanceof Color ) {
            return new ColorUIResource ( ( Color ) value );
        } else if ( value instanceof Font ) {
            return new FontUIResource ( ( Font ) value );
        } else if ( value instanceof UIDefaults.LazyValue ) {
            value = ( ( UIDefaults.LazyValue ) value ).createValue ( null );
        } else if ( value instanceof UIDefaults.ActiveValue ) {
            value = ( ( UIDefaults.ActiveValue ) value ).createValue ( null );
        }
    }
    return value;
}
