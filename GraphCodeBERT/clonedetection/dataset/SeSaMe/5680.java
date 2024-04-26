public int distanceFromRoot() {
    if ( upstream.isRootNode() ) {
        return 1;
    } else {
        return upstream.distanceFromRoot() + 1;
    }
}
