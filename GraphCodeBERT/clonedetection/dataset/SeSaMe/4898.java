public void benchmark ( List<UniformRandomProvider> rngList ) {
    final Random jdk = new Random();
    final PerfTestUtils.RunTest[] candidates = new PerfTestUtils.RunTest[rngList.size() + 1];
    candidates[0] = new PerfTestUtils.RunTest ( jdk.toString() ) {
        @Override
        public Double call() throws Exception {
            return ( double ) jdk.nextInt();
        }
    };
    for ( int i = 0; i < rngList.size(); i++ ) {
        final UniformRandomProvider rng = rngList.get ( i );
        candidates[i + 1] = new PerfTestUtils.RunTest ( rng.toString() ) {
            @Override
            public Double call() throws Exception {
                return ( double ) rng.nextInt();
            }
        };
    }
    PerfTestUtils.timeAndReport ( "nextInt()",
                                  MAX_NAME_WIDTH,
                                  NUM_CALLS,
                                  NUM_STATS,
                                  false,
                                  candidates );
    candidates[0] = new PerfTestUtils.RunTest ( jdk.toString() ) {
        @Override
        public Double call() throws Exception {
            return ( double ) jdk.nextDouble();
        }
    };
    for ( int i = 0; i < rngList.size(); i++ ) {
        final UniformRandomProvider rng = rngList.get ( i );
        candidates[i + 1] = new PerfTestUtils.RunTest ( rng.toString() ) {
            @Override
            public Double call() throws Exception {
                return rng.nextDouble();
            }
        };
    }
    PerfTestUtils.timeAndReport ( "nextDouble()",
                                  MAX_NAME_WIDTH,
                                  NUM_CALLS,
                                  NUM_STATS,
                                  false,
                                  candidates );
    candidates[0] = new PerfTestUtils.RunTest ( jdk.toString() ) {
        @Override
        public Double call() throws Exception {
            return ( double ) jdk.nextLong();
        }
    };
    for ( int i = 0; i < rngList.size(); i++ ) {
        final UniformRandomProvider rng = rngList.get ( i );
        candidates[i + 1] = new PerfTestUtils.RunTest ( rng.toString() ) {
            @Override
            public Double call() throws Exception {
                return ( double ) rng.nextLong();
            }
        };
    }
    PerfTestUtils.timeAndReport ( "nextLong()",
                                  MAX_NAME_WIDTH,
                                  NUM_CALLS,
                                  NUM_STATS,
                                  false,
                                  candidates );
}
