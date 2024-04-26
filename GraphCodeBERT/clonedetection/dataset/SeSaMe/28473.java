final void push ( ForkJoinTask<?> task ) {
    ForkJoinTask<?>[] a;
    int s = top, d, cap, m;
    ForkJoinPool p = pool;
    if ( ( a = array ) != null && ( cap = a.length ) > 0 ) {
        QA.setRelease ( a, ( m = cap - 1 ) & s, task );
        top = s + 1;
        if ( ( ( d = s - ( int ) BASE.getAcquire ( this ) ) & ~1 ) == 0 &&
                p != null ) {                
            VarHandle.fullFence();
            p.signalWork();
        } else if ( d == m ) {
            growArray ( false );
        }
    }
}
