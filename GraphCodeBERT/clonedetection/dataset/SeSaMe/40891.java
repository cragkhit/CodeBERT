public static boolean isMetaTempo ( MidiMessage midiMsg ) {
    if ( midiMsg.getLength() != 6
            || midiMsg.getStatus() != MetaMessage.META ) {
        return false;
    }
    byte[] msg = midiMsg.getMessage();
    return ( ( msg[1] & 0xFF ) == META_TEMPO_TYPE ) && ( msg[2] == 3 );
}
