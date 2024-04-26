public static GarbageProducer getGarbageProducer ( String id ) {
    if ( id == null || id.equals ( "byteArr" ) ) {
        return new ByteArrayProducer();
    } else if ( id.equals ( "booleanArr" ) ) {
        return new BooleanArrayProducer();
    } else if ( id.equals ( "shortArr" ) ) {
        return new ShortArrayProducer();
    } else if ( id.equals ( "charArr" ) ) {
        return new CharArrayProducer();
    } else if ( id.equals ( "intArr" ) ) {
        return new IntArrayProducer();
    } else if ( id.equals ( "longArr" ) ) {
        return new LongArrayProducer();
    } else if ( id.equals ( "floatArr" ) ) {
        return new FloatArrayProducer();
    } else if ( id.equals ( "doubleArr" ) ) {
        return new DoubleArrayProducer();
    } else if ( id.equals ( "objectArr" ) ) {
        return new ObjectArrayProducer();
    } else if ( id.equals ( "randomString" ) ) {
        return new RandomStringProducer();
    } else if ( id.equals ( "simpleString" ) ) {
        return new SimpleStringProducer();
    } else if ( id.startsWith ( "interned(" ) ) {
        return new InternedStringProducer ( getGarbageProducer ( getInBrackets ( id ) ) );
    } else if ( id.startsWith ( "linearList(" ) ) {
        return new LinearListProducer ( MemoryStrategy.fromString ( getInBrackets ( id ) ) );
    } else if ( id.startsWith ( "circularList(" ) ) {
        return new CircularListProducer ( MemoryStrategy.fromString ( getInBrackets ( id ) ) );
    } else if ( id.startsWith ( "nonbranchyTree(" ) ) {
        return new NonbranchyTreeProducer ( MemoryStrategy.fromString ( getInBrackets ( id ) ) );
    } else if ( id.equals ( "class" ) ) {
        return new GeneratedClassProducer();
    } else if ( id.startsWith ( "hashed(" ) ) {
        return new HashedGarbageProducer ( getGarbageProducer ( getInBrackets ( id ) ) );
    } else if ( id.startsWith ( "random(" ) ) {
        return new RandomProducer ( getGarbageProducerList ( getInBrackets ( id ) ) );
    } else if ( id.startsWith ( "twofields(" ) ) {
        return new TwoFieldsObjectProducer ( getGarbageProducer ( getInBrackets ( id ) ) );
    } else if ( id.startsWith ( "arrayof(" ) ) {
        return new ArrayOfProducer ( getGarbageProducer ( getInBrackets ( id ) ) );
    } else if ( id.startsWith ( "trace(" ) ) {
        return new TraceProducer ( getGarbageProducer ( getInBrackets ( id ) ) );
    } else {
        throw new TestBug ( "Invalid garbage producer identifier: " + id );
    }
}
