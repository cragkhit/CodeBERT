public Object clone() {
    try {
        IdentityHashMap<?, ?> m = ( IdentityHashMap<?, ?> ) super.clone();
        m.entrySet = null;
        m.table = table.clone();
        return m;
    } catch ( CloneNotSupportedException e ) {
        throw new InternalError ( e );
    }
}
