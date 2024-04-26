public double computeTopographicError() {
    return MapUtils.computeTopographicError ( createIterable(),
            sofm.getNetwork(),
            distance );
}
