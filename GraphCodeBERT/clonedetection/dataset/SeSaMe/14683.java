public Result getResult() {
    boolean hasValue = false;
    String typeName = null;
    String toString = null;
    if ( DEBUG ) {
        hasValue = true;
        typeName = "TargetInterface in debug mode. Run d:\\eval\\TestCodeSnippet.bat d:\\eval\\snippets\\" + this.codeSnippetClassName;
        toString = "";
    } else {
        if ( isConnected() ) {
            try {
                DataInputStream in = new DataInputStream ( this.socket.getInputStream() );
                hasValue = in.readBoolean();
                if ( hasValue ) {
                    typeName = in.readUTF();
                    toString = in.readUTF();
                } else {
                    typeName = null;
                    toString = null;
                }
            } catch ( IOException e ) {
                hasValue = true;
                typeName = e.getMessage();
                toString = "";
                disconnect();
            }
        } else {
            hasValue = true;
            typeName = "Connection has been lost";
            toString = "";
        }
    }
    if ( TIMING ) {
        System.out.println ( "Time to send compiled classes, run on target and get result is " + ( System.currentTimeMillis() - this.sentTime ) + "ms" );
    }
    Result result = new Result();
    result.displayString = toString == null ? null : toString.toCharArray();
    result.typeName = typeName == null ? null : typeName.toCharArray();
    return result;
}
