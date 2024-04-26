public static List<List<Writable>> executeJoin ( Join join, List<List<Writable>> left,
        List<List<Writable>> right ) {
    String[] leftColumnNames = join.getJoinColumnsLeft();
    int[] leftColumnIndexes = new int[leftColumnNames.length];
    for ( int i = 0; i < leftColumnNames.length; i++ ) {
        leftColumnIndexes[i] = join.getLeftSchema().getIndexOfColumn ( leftColumnNames[i] );
    }
    ExtractKeysFunction extractKeysFunction1 = new ExtractKeysFunction ( leftColumnIndexes );
    List<Pair<List<Writable>, List<Writable>>> leftJV = left.stream()
        .filter ( input -> input.size() != leftColumnNames.length ).map ( input ->
            extractKeysFunction1.apply ( input ) ).collect ( toList() );
    String[] rightColumnNames = join.getJoinColumnsRight();
    int[] rightColumnIndexes = new int[rightColumnNames.length];
    for ( int i = 0; i < rightColumnNames.length; i++ ) {
        rightColumnIndexes[i] = join.getRightSchema().getIndexOfColumn ( rightColumnNames[i] );
    }
    ExtractKeysFunction extractKeysFunction = new ExtractKeysFunction ( rightColumnIndexes );
    List<Pair<List<Writable>, List<Writable>>> rightJV =
        right.stream().filter ( input -> input.size() != rightColumnNames.length )
        .map ( input -> extractKeysFunction.apply ( input ) )
        .collect ( toList() );
    Map<List<Writable>, Pair<List<List<Writable>>, List<List<Writable>>>> cogroupedJV = FunctionalUtils.cogroup ( leftJV, rightJV );
    ExecuteJoinFromCoGroupFlatMapFunction executeJoinFromCoGroupFlatMapFunction = new ExecuteJoinFromCoGroupFlatMapFunction ( join );
    List<List<Writable>> ret =  cogroupedJV.entrySet().stream()
                                .flatMap ( input ->
                                           executeJoinFromCoGroupFlatMapFunction.call ( Pair.of ( input.getKey(), input.getValue() ) ).stream() )
                                .collect ( toList() );
    Schema retSchema = join.getOutputSchema();
    return ArrowConverter.toArrowWritables ( ArrowConverter.toArrowColumns ( bufferAllocator, retSchema, ret ), retSchema );
}
