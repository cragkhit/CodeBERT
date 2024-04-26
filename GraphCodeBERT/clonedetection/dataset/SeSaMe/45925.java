boolean hasActionListener() {
    Object[] listeners = listenerList.getListenerList();
    for ( int i = listeners.length - 2; i >= 0; i -= 2 ) {
        if ( listeners[i] == ActionListener.class ) {
            return true;
        }
    }
    return false;
}
