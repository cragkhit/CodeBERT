@Override
public void onNDArrayMessage ( NDArrayMessage message ) {
    try ( AeronNDArrayPublisher publisher = AeronNDArrayPublisher.builder().streamId ( streamId ).ctx ( aeronContext )
                                                .channel ( masterUrl ).build() ) {
        publisher.publish ( message );
        log.debug ( "NDArray PublishingListener publishing to channel " + masterUrl + ":" + streamId );
    } catch ( Exception e ) {
        throw new RuntimeException ( e );
    }
}
