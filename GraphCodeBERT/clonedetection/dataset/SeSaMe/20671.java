public static void main ( String[] args ) {
    Random r = new Random ( 11 );
    int[] a = new int[100];
    for ( int i = 0; i < 1000; i++ ) {
        a[r.nextInt ( 100 )]++;
    }
    for ( int i = 0; i < 100; i++ ) {
        System.out.println ( times ( a[i] ) );
    }
}
