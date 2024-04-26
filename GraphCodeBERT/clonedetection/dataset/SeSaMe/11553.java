public void endTest ( Test test ) {
    for ( Enumeration e = cloneListeners().elements(); e.hasMoreElements(); ) {
        ( ( TestListener ) e.nextElement() ).endTest ( test );
    }
}
