ArrayList<ResolvedJavaMethod> getMethods() {
    ArrayList<ResolvedJavaMethod> m = methods;
    methods = null; 
    return m;
}
