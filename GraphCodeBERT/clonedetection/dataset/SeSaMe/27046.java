public boolean parseHTTP ( MessageHeader responses, ProgressSource pi, HttpURLConnection httpuc )
throws IOException {
    try {
        serverInput = serverSocket.getInputStream();
        if ( capture != null ) {
            serverInput = new HttpCaptureInputStream ( serverInput, capture );
        }
        serverInput = new BufferedInputStream ( serverInput );
        return ( parseHTTPHeader ( responses, pi, httpuc ) );
    } catch ( SocketTimeoutException stex ) {
        if ( ignoreContinue ) {
            closeServer();
        }
        throw stex;
    } catch ( IOException e ) {
        closeServer();
        cachedHttpClient = false;
        if ( !failedOnce && requests != null ) {
            failedOnce = true;
            if ( getRequestMethod().equals ( "CONNECT" )
                    || streaming
                    || ( httpuc.getRequestMethod().equals ( "POST" )
                         && !retryPostProp ) ) {
            }  else {
                openServer();
                if ( needsTunneling() ) {
                    MessageHeader origRequests = requests;
                    httpuc.doTunneling();
                    requests = origRequests;
                }
                afterConnect();
                writeRequests ( requests, poster );
                return parseHTTP ( responses, pi, httpuc );
            }
        }
        throw e;
    }
}
