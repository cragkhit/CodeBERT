public Root mostInteresting ( Root other ) {
    if ( other.type > this.type ) {
        return other;
    } else {
        return this;
    }
}
