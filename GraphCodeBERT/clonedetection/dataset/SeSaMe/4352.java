public static void checkMultiplicationCompatible ( final AnyMatrix left, final AnyMatrix right )
throws DimensionMismatchException {
    if ( left.getColumnDimension() != right.getRowDimension() ) {
        throw new DimensionMismatchException ( left.getColumnDimension(),
                                               right.getRowDimension() );
    }
}
