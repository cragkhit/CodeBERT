final TreeNode<K, V> putTreeVal ( int h, K k, V v ) {
    Class<?> kc = null;
    boolean searched = false;
    for ( TreeNode<K, V> p = root;; ) {
        int dir, ph;
        K pk;
        if ( p == null ) {
            first = root = new TreeNode<K, V> ( h, k, v, null, null );
            break;
        } else if ( ( ph = p.hash ) > h ) {
            dir = -1;
        } else if ( ph < h ) {
            dir = 1;
        } else if ( ( pk = p.key ) == k || ( pk != null && k.equals ( pk ) ) ) {
            return p;
        } else if ( ( kc == null &&
                      ( kc = comparableClassFor ( k ) ) == null ) ||
                    ( dir = compareComparables ( kc, k, pk ) ) == 0 ) {
            if ( !searched ) {
                TreeNode<K, V> q, ch;
                searched = true;
                if ( ( ( ch = p.left ) != null &&
                        ( q = ch.findTreeNode ( h, k, kc ) ) != null ) ||
                        ( ( ch = p.right ) != null &&
                          ( q = ch.findTreeNode ( h, k, kc ) ) != null ) ) {
                    return q;
                }
            }
            dir = tieBreakOrder ( k, pk );
        }
        TreeNode<K, V> xp = p;
        if ( ( p = ( dir <= 0 ) ? p.left : p.right ) == null ) {
            TreeNode<K, V> x, f = first;
            first = x = new TreeNode<K, V> ( h, k, v, f, xp );
            if ( f != null ) {
                f.prev = x;
            }
            if ( dir <= 0 ) {
                xp.left = x;
            } else {
                xp.right = x;
            }
            if ( !xp.red ) {
                x.red = true;
            } else {
                lockRoot();
                try {
                    root = balanceInsertion ( root, x );
                } finally {
                    unlockRoot();
                }
            }
            break;
        }
    }
    assert checkInvariants ( root );
    return null;
}
