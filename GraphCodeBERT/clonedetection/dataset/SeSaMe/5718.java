@Override
public void clear() {
    RocksIterator iterator = db.newIterator();
    while ( iterator.isValid() )
        try {
            db.remove ( iterator.key() );
        } catch ( RocksDBException e ) {
            throw new RuntimeException ( e );
        }
    iterator.close();
    size = 0;
}
