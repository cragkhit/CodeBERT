@Override
public boolean isEmpty() {
    for ( int i = this.composite.length - 1; i >= 0; --i ) {
        if ( !this.composite[i].isEmpty() ) {
            return false;
        }
    }
    return true;
}
