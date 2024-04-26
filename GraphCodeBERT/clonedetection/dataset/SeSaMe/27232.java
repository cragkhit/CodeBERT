static void offerFirstTemporaryDirectBuffer ( ByteBuffer buf ) {
    if ( isBufferTooLarge ( buf ) ) {
        free ( buf );
        return;
    }
    assert buf != null;
    BufferCache cache = bufferCache.get();
    if ( !cache.offerFirst ( buf ) ) {
        free ( buf );
    }
}
