public long getCodeIndex ( long classID, long methodID, int lineNumber ) {
    String commandName = "Method.LineTable";
    CommandPacket command = new CommandPacket ( JDWP.Command.Method.LineTable );
    command.addReferenceTypeID ( classID );
    command.addMethodID ( methodID );
    ReplyPacket reply = receiveReplyFor ( command, commandName );
    String msg = "Error occured while getting code index for line number: " + lineNumber;
    try {
        reply.resetPosition();
        long start = reply.getLong();
        long end = reply.getLong();
        int lines = reply.getInt();
        for ( int i = 0; i < lines; i++ ) {
            long lineCodeIndex = reply.getLong();
            int line = reply.getInt();
            if ( lineNumber == line ) {
                return lineCodeIndex;
            }
        }
    } catch ( BoundException e ) {
        complain ( "Unable to parse reply packet for " + commandName + " command:\n\t"
                   + e.getMessage() );
        display ( "Reply packet:\n" + reply );
        throw new Failure ( msg );
    }
    throw new Failure ( "No code index found for line number: " + lineNumber );
}
