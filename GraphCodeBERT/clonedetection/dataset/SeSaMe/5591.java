public static FragmentHandler printStringMessage ( final int streamId ) {
    return ( buffer, offset, length, header ) -> {
        final byte[] data = new byte[length];
        buffer.getBytes ( offset, data );
        System.out.println ( String.format ( "Message to stream %d from session %d (%d@%d) <<%s>>", streamId,
                                             header.sessionId(), length, offset, new String ( data ) ) );
    };
}
