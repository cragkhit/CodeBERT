public List<String> asLabels() {
    List<String> labels = new ArrayList<>();
    for ( T element : getElements() ) {
        labels.add ( element.getLabel() );
    }
    return labels;
}
