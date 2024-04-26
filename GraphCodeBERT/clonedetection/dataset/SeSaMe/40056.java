@Deprecated
public Dimension preferredSize() {
    Dimension dim = prefSize;
    if ( dim == null || ! ( isPreferredSizeSet() || isValid() ) ) {
        synchronized ( getTreeLock() ) {
            prefSize = ( peer != null ) ?
                       peer.getPreferredSize() :
                       getMinimumSize();
            dim = prefSize;
        }
    }
    return new Dimension ( dim );
}
