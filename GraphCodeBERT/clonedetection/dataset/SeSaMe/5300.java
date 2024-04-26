public static void skip ( DataInput in ) throws IOException {
    int length = WritableUtils.readVInt ( in );
    WritableUtils.skipFully ( in, length );
}
