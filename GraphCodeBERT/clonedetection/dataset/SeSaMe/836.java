public SortedSet<LocalizedMessage> getMessages() {
    return new TreeSet<> ( context.get().messages );
}
