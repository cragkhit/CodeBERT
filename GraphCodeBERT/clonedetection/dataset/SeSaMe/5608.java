public String connectionUrl() {
    String[] split = channel.replace ( "aeron:udp?endpoint=", "" ).split ( ":" );
    String host = split[0];
    int port = Integer.parseInt ( split[1] );
    return AeronConnectionInformation.of ( host, port, streamId ).toString();
}
