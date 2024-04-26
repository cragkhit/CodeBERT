public boolean terminated() {
    try {
        int value = process.exitValue();
        return true;
    } catch ( IllegalThreadStateException e ) {
        return false;
    }
}
