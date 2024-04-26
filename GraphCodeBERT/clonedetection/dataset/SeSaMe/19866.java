public long getThreadID ( String name ) {
    int threads = 0;
    long threadIDs[] = null;
    {
        String commandName = "VirtualMachine.AllThreads";
        CommandPacket command = new CommandPacket ( JDWP.Command.VirtualMachine.AllThreads );
        ReplyPacket reply = receiveReplyFor ( command, commandName );
        reply.resetPosition();
        try {
            threads = reply.getInt();
            threadIDs = new long[threads];
            for ( int i = 0; i < threads; i++ ) {
                threadIDs[i] = reply.getObjectID();
            }
        } catch ( BoundException e ) {
            complain ( "Unable to parse reply packet for " + commandName + " command:\n\t"
                       + e.getMessage() );
            display ( "Reply packet:\n" + reply );
            throw new Failure ( "Error occured while getting threadID for thread name: "
                                + name );
        }
    }
    for ( int i = 0; i < threads; i++ ) {
        String commandName = "ThreadReference.Name";
        CommandPacket command = new CommandPacket ( JDWP.Command.ThreadReference.Name );
        command.addObjectID ( threadIDs[i] );
        ReplyPacket reply = receiveReplyFor ( command, commandName );
        try {
            reply.resetPosition();
            String threadName = reply.getString();
            if ( threadName.equals ( name ) ) {
                return threadIDs[i];
            }
        } catch ( BoundException e ) {
            complain ( "Unable to parse reply packet for " + commandName + " command:\n\t"
                       + e.getMessage() );
            display ( "Reply packet:\n" + reply );
            throw new Failure ( "Error occured while getting name for threadID: "
                                + threadIDs[i] );
        }
    }
    throw new Failure ( "No threadID found for thread name: " + name );
}
