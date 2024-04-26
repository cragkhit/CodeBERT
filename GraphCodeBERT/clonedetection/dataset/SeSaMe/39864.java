public void addNotify() {
    synchronized ( getTreeLock() ) {
        if ( peer == null ) {
            peer = getComponentFactory().createCheckboxMenuItem ( this );
        }
        super.addNotify();
    }
}
