public synchronized void launch() {
    log.info ( "ModelParameterServer starts" );
    if ( launchLock.get() ) {
        return;
    }
    transport.setRestartCallback ( new RestartCallback() {
        @Override
        public void call ( HandshakeResponse response ) {
            try {
                log.info ( "Restart callback started..." );
                val msg = new ModelParametersRequest();
                val rootId = transport.getRootId();
                ModelParametersMessage modelParams = transport.sendMessageBlocking ( msg, rootId );
                val mParams = modelParams.getPayload();
                modelParamsSubsribers.forEach ( s -> s.onNext ( mParams ) );
                iterationNumber.set ( modelParams.getIterationNumber() );
                epochNumber.set ( modelParams.getEpochNumber() );
                UpdaterParametersMessage updaterParams = transport.sendMessageBlocking ( new UpdaterParametersRequest(), rootId );
                val uParams = updaterParams.getPayload();
                if ( uParams != null ) {
                    updaterParamsSubscribers.forEach ( s -> s.onNext ( uParams ) );
                    log.info ( "Updater parameters propagated..." );
                }
            } catch ( Exception e ) {
                log.error ( "RestartCallback processing exception: {}", e );
                throw new RuntimeException ( e );
            }
        }
    } );
    transport.addRequestConsumer ( ModelParametersRequest.class, new Consumer<ModelParametersRequest>() {
        @Override
        public void accept ( ModelParametersRequest modelParametersRequest ) throws Exception {
            val msg = new ModelParametersMessage ( java.util.UUID.randomUUID().toString(), updatesSubscribers.get ( 0 ).getParametersArray() );
            msg.setRequestId ( modelParametersRequest.getRequestId() );
            msg.setIterationNumber ( iterationNumber.get() );
            msg.setEpochNumber ( epochNumber.get() );
            transport.sendMessage ( msg, modelParametersRequest.getOriginatorId() );
        }
    } );
    if ( masterMode ) {
        addUpdaterParamsSubscriber ( new AbstractSubscriber<INDArray>() {
            @Override
            public void onNext ( INDArray array ) {
                if ( gotFinalState.get() ) {
                    return;
                }
                try {
                    updaterParamsLock.writeLock().lock();
                    updaterParameters.get().setParameters ( array );
                    updaterParameters.get().setTimeReceived ( System.currentTimeMillis() );
                } finally {
                    updaterParamsLock.writeLock().unlock();
                }
            }
        } );
        transport.addRequestConsumer ( UpdaterParametersRequest.class, new Consumer<UpdaterParametersRequest>() {
            @Override
            public void accept ( UpdaterParametersRequest updaterParametersRequest ) throws Exception {
                if ( !gotFinalState.get() ) {
                    val tId = transport.getRandomDownstreamFrom ( transport.getRootId(), updaterParametersRequest.getOriginatorId() );
                    log.info ( "Sending UpdaterParameters request to [{}]", tId );
                    UpdaterParametersMessage updaterParams = transport.sendMessageBlocking ( new UpdaterParametersRequest(), tId );
                    val uParams = updaterParams.getPayload();
                    try {
                        updaterParamsLock.writeLock().lock();
                        if ( updaterParameters.get() == null ) {
                            updaterParameters.set ( new UpdaterParametersHolder ( uParams, System.currentTimeMillis(), false ) );
                        } else {
                            updaterParameters.get().setParameters ( uParams );
                        }
                    } finally {
                        updaterParamsLock.writeLock().unlock();
                    }
                }
                try {
                    updaterParamsLock.readLock().lock();
                    log.info ( "Trying to send back Updater parameters..." );
                    val msg = new UpdaterParametersMessage ( java.util.UUID.randomUUID().toString(), updaterParameters.get().getParameters() );
                    msg.setRequestId ( updaterParametersRequest.getRequestId() );
                    transport.sendMessage ( msg, updaterParametersRequest.getOriginatorId() );
                } finally {
                    updaterParamsLock.readLock().unlock();
                }
            }
        } );
    } else {
        transport.addRequestConsumer ( UpdaterParametersRequest.class, new Consumer<UpdaterParametersRequest>() {
            @Override
            public void accept ( UpdaterParametersRequest updaterParametersRequest ) throws Exception {
                log.info ( "Trying to send back Updater parameters..." );
                if ( updaterParametersProvider == null ) {
                    log.warn ( "UpdaterParametersProvider wasn't set!" );
                    val msg = new UpdaterParametersMessage ( java.util.UUID.randomUUID().toString(), null );
                    msg.setRequestId ( updaterParametersRequest.getRequestId() );
                    transport.sendMessage ( msg, updaterParametersRequest.getOriginatorId() );
                } else {
                    val msg = new UpdaterParametersMessage ( java.util.UUID.randomUUID().toString(), updaterParametersProvider.getUpdaterParameters() );
                    msg.setRequestId ( updaterParametersRequest.getRequestId() );
                    transport.sendMessage ( msg, updaterParametersRequest.getOriginatorId() );
                }
            }
        } );
    }
    disposable = Flowable.fromPublisher ( transport.incomingPublisher() ).subscribe ( message -> {
        if ( message instanceof GradientsUpdateMessage ) {
            val gum = ( GradientsUpdateMessage ) message;
            if ( iterationNumber.get() < gum.getIteration() ) {
                iterationNumber.set ( gum.getIteration() );
            }
            if ( epochNumber.get() < gum.getEpoch() ) {
                epochNumber.set ( gum.getEpoch() );
            }
            if ( updatesSubscribers.isEmpty() ) {
                log.info ( "Storing GradientsUpdateMessage into backlog queue..." );
                updatesQueue.add ( message.getPayload() );
            } else {
                log.info ( "Propagating GradientsUpdateMessage to subscribers: [{}]", updatesSubscribers.size() );
                updatesSubscribers.forEach ( s -> s.onNext ( message.getPayload() ) );
            }
        } else {
            throw new UnsupportedOperationException ( "Unknown message received: [" + message.getClass().getCanonicalName() + "]" );
        }
    } );
    if ( this.masterMode ) {
        transport.launchAsMaster();
    } else {
        transport.launch();
    }
    stopLock.set ( false );
    launchLock.set ( true );
}
