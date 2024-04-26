public static UnivariateFunction combine ( final BivariateFunction combiner,
        final UnivariateFunction f,
        final UnivariateFunction g ) {
    return new UnivariateFunction() {
        @Override
        public double value ( double x ) {
            return combiner.value ( f.value ( x ), g.value ( x ) );
        }
    };
}
