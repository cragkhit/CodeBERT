public static Key translateKeyEvent ( KeyEvent evt ) {
    int modifiers = evt.getModifiers();
    Key returnValue = null;
    switch ( evt.getID() ) {
    case KeyEvent.KEY_PRESSED:
        int keyCode = evt.getKeyCode();
        if ( ( keyCode >= KeyEvent.VK_0 && keyCode <= KeyEvent.VK_9 )
                || ( keyCode >= KeyEvent.VK_A && keyCode <= KeyEvent.VK_Z ) ) {
            if ( KeyEventWorkaround.ALTERNATIVE_DISPATCHER ) {
                return null;
            } else {
                returnValue = new Key ( modifiersToString ( modifiers ),
                                        '\0', Character.toUpperCase ( ( char ) keyCode ) );
            }
        } else {
            if ( keyCode == KeyEvent.VK_TAB ) {
                evt.consume();
                returnValue = new Key ( modifiersToString ( modifiers ),
                                        keyCode, '\0' );
            } else if ( keyCode == KeyEvent.VK_SPACE ) {
                if ( ( modifiers & ~InputEvent.SHIFT_MASK ) == 0 ) {
                    returnValue = null;
                } else {
                    returnValue = new Key ( modifiersToString ( modifiers ), 0,
                                            ' ' );
                }
            } else {
                returnValue = new Key ( modifiersToString ( modifiers ),
                                        keyCode, '\0' );
            }
        }
        break;
    case KeyEvent.KEY_TYPED:
        char ch = evt.getKeyChar();
        switch ( ch ) {
        case '\n':
        case '\t':
        case '\b':
            return null;
        case ' ':
            if ( ( modifiers & ~InputEvent.SHIFT_MASK ) != 0 ) {
                return null;
            }
        }
        int ignoreMods;
        if ( KeyEventWorkaround.ALT_KEY_PRESSED_DISABLED ) {
            ignoreMods = ( InputEvent.SHIFT_MASK | InputEvent.ALT_GRAPH_MASK | InputEvent.ALT_MASK );
        } else {
            ignoreMods = ( InputEvent.SHIFT_MASK | InputEvent.ALT_GRAPH_MASK );
        }
        if ( ( modifiers & InputEvent.ALT_GRAPH_MASK ) == 0
                && evt.getWhen() - KeyEventWorkaround.lastKeyTime < 750
                && ( KeyEventWorkaround.modifiers & ~ignoreMods ) != 0 ) {
            if ( KeyEventWorkaround.ALTERNATIVE_DISPATCHER ) {
                returnValue = new Key ( modifiersToString ( modifiers ), 0, ch );
            } else {
                return null;
            }
        } else {
            if ( ch == ' ' ) {
                returnValue = new Key ( modifiersToString ( modifiers ), 0, ch );
            } else {
                returnValue = new Key ( null, 0, ch );
            }
        }
        break;
    default:
        return null;
    }
    Key trans = transMap.get ( returnValue );
    if ( trans == null ) {
        return returnValue;
    } else {
        return trans;
    }
} 
