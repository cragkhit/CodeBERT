public String getMessage() {
    if ( fMessage == null ) {
        fMessage = fFormatter.formatMessage ( fLocale, fKey, fArguments );
        fFormatter = null;
        fLocale = null;
    }
    return fMessage;
} 
