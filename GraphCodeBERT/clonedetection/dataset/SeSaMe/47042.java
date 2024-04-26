XMenuItemPeer[] copyItems() {
    synchronized ( getMenuTreeLock() ) {
        return items.toArray ( new XMenuItemPeer[] {} );
    }
}
