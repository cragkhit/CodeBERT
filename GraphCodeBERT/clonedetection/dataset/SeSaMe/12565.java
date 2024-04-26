public long remove ( String str ) throws CoreException {
    if ( this.lazyCache != null ) {
        this.lazyCache.remove ( str );
    }
    long prev = 0;
    long curr = getHead();
    while ( curr != 0 ) {
        long next = NodeType.Next.get ( this.db, curr );
        long item = NodeType.Item.get ( this.db, curr );
        IString string = this.db.getString ( item );
        if ( string.compare ( str, true ) == 0 ) {
            if ( this.head != curr ) {
                NodeType.Next.put ( this.db, prev, next );
            } else {
                this.db.putRecPtr ( this.ptr, next );
                this.head = next;
            }
            this.db.free ( curr, Database.POOL_STRING_SET );
            return item;
        }
        prev = curr;
        curr = next;
    }
    return 0;
}
