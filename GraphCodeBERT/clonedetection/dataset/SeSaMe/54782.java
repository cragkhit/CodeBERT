public void invokeCleaner ( java.nio.ByteBuffer directBuffer ) {
    if ( !directBuffer.isDirect() ) {
        throw new IllegalArgumentException ( "buffer is non-direct" );
    }
    DirectBuffer db = ( DirectBuffer ) directBuffer;
    if ( db.attachment() != null ) {
        throw new IllegalArgumentException ( "duplicate or slice" );
    }
    Cleaner cleaner = db.cleaner();
    if ( cleaner != null ) {
        cleaner.clean();
    }
}
