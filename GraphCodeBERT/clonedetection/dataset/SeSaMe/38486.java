protected Iterator<BCSChild> bcsChildren() {
    synchronized ( children ) {
        return children.values().iterator();
    }
}
