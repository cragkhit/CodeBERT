public JavaClass[] getAllInterfaces() throws ClassNotFoundException {
    final ClassQueue queue = new ClassQueue();
    final Set<JavaClass> allInterfaces = new TreeSet<>();
    queue.enqueue ( this );
    while ( !queue.empty() ) {
        final JavaClass clazz = queue.dequeue();
        final JavaClass souper = clazz.getSuperClass();
        final JavaClass[] _interfaces = clazz.getInterfaces();
        if ( clazz.isInterface() ) {
            allInterfaces.add ( clazz );
        } else {
            if ( souper != null ) {
                queue.enqueue ( souper );
            }
        }
        for ( final JavaClass _interface : _interfaces ) {
            queue.enqueue ( _interface );
        }
    }
    return allInterfaces.toArray ( new JavaClass[allInterfaces.size()] );
}
