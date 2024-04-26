@Override
public int getSupportUpperBound() {
    int max = Integer.MIN_VALUE;
    for ( final Pair<Integer, Double> sample : innerDistribution.getPmf() ) {
        if ( sample.getKey() > max && sample.getValue() > 0 ) {
            max = sample.getKey();
        }
    }
    return max;
}
