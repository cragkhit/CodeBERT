public Set<String> missingOnnxOps() {
    Set<String> copy = new HashSet<> ( onnxOpDescriptors.keySet() );
    copy.removeAll ( onnxNames.keySet() );
    return copy;
}
