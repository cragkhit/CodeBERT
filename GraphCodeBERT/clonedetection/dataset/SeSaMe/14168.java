protected IClasspathEntry[] defaultClasspath() {
    return new IClasspathEntry[] {
               JavaCore.newSourceEntry ( this.project.getFullPath() )
           };
}
