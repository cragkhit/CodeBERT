public void removeListener ( EventListener listener ) {
    display ( "Removing listener " + listener );
    synchronized ( listeners ) {
        listeners.remove ( listener );
    }
}
