public Builder version ( String v ) {
    Version ver = cachedVersion;
    if ( ver != null && v.equals ( ver.toString() ) ) {
        version = ver;
    } else {
        cachedVersion = version = Version.parse ( v );
    }
    return this;
}
