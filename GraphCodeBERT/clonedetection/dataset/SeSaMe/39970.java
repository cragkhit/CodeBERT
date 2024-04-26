public Dimension preferredLayoutSize ( Container parent ) {
    synchronized ( parent.getTreeLock() ) {
        Insets insets = parent.getInsets();
        int ncomponents = parent.getComponentCount();
        int w = 0;
        int h = 0;
        for ( int i = 0 ; i < ncomponents ; i++ ) {
            Component comp = parent.getComponent ( i );
            Dimension d = comp.getPreferredSize();
            if ( d.width > w ) {
                w = d.width;
            }
            if ( d.height > h ) {
                h = d.height;
            }
        }
        return new Dimension ( insets.left + insets.right + w + hgap * 2,
                               insets.top + insets.bottom + h + vgap * 2 );
    }
}
