protected List<String> getHeaderLines() {
    final List<String> copy = new ArrayList<> ( readerLines );
    return Collections.unmodifiableList ( copy );
}
