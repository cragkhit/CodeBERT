@Override
public boolean validateEvent ( ListenerEvent event, long argument ) {
    try {
        locker.acquire();
        if ( event == targetEvent && argument % targetFrequency == 0 ) {
            return true;
        } else {
            return false;
        }
    } catch ( Exception e ) {
        throw new RuntimeException ( e );
    } finally {
        locker.release();
    }
}
