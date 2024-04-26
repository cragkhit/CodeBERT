public Dfp power10K ( final int e ) {
    Dfp d = newInstance ( getOne() );
    d.exp = e + 1;
    return d;
}
