void getCanonName()
throws UnknownHostException {
    if ( cname != null || invalid || untrusted ) {
        return;
    }
    try {
        if ( addresses == null ) {
            getIP();
        }
        if ( init_with_ip ) {
            cname = addresses[0].getHostName ( false ).toLowerCase();
        } else {
            cname = InetAddress.getByName ( addresses[0].getHostAddress() ).
                    getHostName ( false ).toLowerCase();
        }
    } catch ( UnknownHostException uhe ) {
        invalid = true;
        throw uhe;
    }
}
