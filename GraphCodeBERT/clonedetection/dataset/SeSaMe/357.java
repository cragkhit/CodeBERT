public boolean hasExpired ( long currentTimeMS ) {
    return ( currentTimeMS - expireTimeMS ) >= 0;
}
