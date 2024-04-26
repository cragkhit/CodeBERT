public boolean hasErrors() {
    if ( this.problems == null ) {
        return false;
    } else {
        for ( int i = 0; i < this.problems.length; i++ ) {
            if ( this.problems[i].isError() ) {
                return true;
            }
        }
        return false;
    }
}
