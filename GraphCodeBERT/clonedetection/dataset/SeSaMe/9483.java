public Builder averagingFrequency ( int freq ) {
    if ( freq < 0 ) {
        freq = 0;
    }
    this.averagingFrequency = freq;
    return this;
}
