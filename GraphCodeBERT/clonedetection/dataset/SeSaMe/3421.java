public Incrementor withStart ( int start ) {
    return new Incrementor ( start,
                             this.maximalCount,
                             this.increment,
                             this.maxCountCallback );
}
